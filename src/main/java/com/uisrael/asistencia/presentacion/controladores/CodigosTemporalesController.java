package com.uisrael.asistencia.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.ICodigosTemporalesUseCase;
import com.uisrael.asistencia.infraestructura.seguridad.JwtUtil;
import com.uisrael.asistencia.presentacion.dto.request.CodigosTemporalesRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.CodigosTemporalesResponseDto;
import com.uisrael.asistencia.presentacion.mapeadores.ICodigosTemporalesDtoMapper;

import io.jsonwebtoken.Claims;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asistencia/codigosTemporales")
public class CodigosTemporalesController {
	private final ICodigosTemporalesUseCase codigosTemporalesUseCase;
	private final ICodigosTemporalesDtoMapper mapper;
	private final JwtUtil jwtUtil;

	public CodigosTemporalesController(ICodigosTemporalesUseCase codigosTemporalesUseCase,
			ICodigosTemporalesDtoMapper mapper, JwtUtil jwtUtil) {
		super();
		this.codigosTemporalesUseCase = codigosTemporalesUseCase;
		this.mapper = mapper;
		this.jwtUtil = jwtUtil;
	}

	private boolean noEsAdmin(String authHeader) {
		Claims claims = jwtUtil.validarToken(authHeader.replace("Bearer ", ""));
		String rol = claims.get("rol", String.class);
		return !rol.equals("ADMIN");
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> guardar(@RequestHeader("Authorization") String authHeader,
			@Valid @RequestBody CodigosTemporalesRequestDto requestCodigosTemporales) {
		if (noEsAdmin(authHeader)) {
			return ResponseEntity.status(403).build();
		}
		CodigosTemporalesResponseDto creado = mapper.toResponseDto(codigosTemporalesUseCase.guardar(mapper.toDomain(requestCodigosTemporales)));
		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}

	@GetMapping
	public ResponseEntity<List<CodigosTemporalesResponseDto>> listarTodos(@RequestHeader("Authorization") String authHeader) {
		if (noEsAdmin(authHeader)) {
			return ResponseEntity.status(403).build();
		}
		return ResponseEntity.ok(codigosTemporalesUseCase.listarTodos().stream().map(mapper::toResponseDto).toList());
	}

	@DeleteMapping("/{idCodigosTemporales}")
	public ResponseEntity<Void> eliminar(@RequestHeader("Authorization") String authHeader,
			@PathVariable int idCodigosTemporales) {
		if (noEsAdmin(authHeader)) {
			return ResponseEntity.status(403).build();
		}
		codigosTemporalesUseCase.eliminar(idCodigosTemporales);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("validar")
	public CodigosTemporalesResponseDto validarCodigo(@RequestParam String codigo, @RequestParam int idEmpleado) {
		return mapper.toResponseDto(codigosTemporalesUseCase.validarCodigo(codigo, idEmpleado));
	}

	@GetMapping("/empleado/{idEmpleado}/activos")
	public ResponseEntity<List<CodigosTemporalesResponseDto>> buscarCodigosActivos(@RequestHeader("Authorization") String authHeader,
			@PathVariable int idEmpleado) {
		if (noEsAdmin(authHeader)) {
			return ResponseEntity.status(403).build();
		}
		return ResponseEntity.ok(codigosTemporalesUseCase.buscarCodigosActivosPorEmpleado(idEmpleado).stream().map(mapper::toResponseDto)
				.toList());
	}
}
