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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IAuditoriaUseCase;
import com.uisrael.asistencia.infraestructura.seguridad.JwtUtil;
import com.uisrael.asistencia.presentacion.dto.request.AuditoriaRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.AuditoriaResponseDto;
import com.uisrael.asistencia.presentacion.mapeadores.IAuditoriaDtoMapper;

import io.jsonwebtoken.Claims;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/asistencia/auditoria")
public class AuditoriaController {

	private final IAuditoriaUseCase auditoriaUseCase;
	private final IAuditoriaDtoMapper mapper;
	private final JwtUtil jwtUtil;

	public AuditoriaController(IAuditoriaUseCase auditoriaUseCase, IAuditoriaDtoMapper mapper, JwtUtil jwtUtil) {
		this.auditoriaUseCase = auditoriaUseCase;
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
	public ResponseEntity<AuditoriaResponseDto> guardar(@RequestHeader("Authorization") String authHeader,
			@Valid @RequestBody AuditoriaRequestDto requestAuditoria) {
		if (noEsAdmin(authHeader)) {
			return ResponseEntity.status(403).build();
		}
		AuditoriaResponseDto creado = mapper.toResponseDto(auditoriaUseCase.guardar(mapper.toDomain(requestAuditoria)));
		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}

	@GetMapping
	public ResponseEntity<List<AuditoriaResponseDto>> listarTodos(@RequestHeader("Authorization") String authHeader) {
		if (noEsAdmin(authHeader)) {
			return ResponseEntity.status(403).build();
		}
		return ResponseEntity.ok(auditoriaUseCase.listarTodos().stream().map(mapper::toResponseDto).toList());
	}

	@DeleteMapping("/{idAuditoria}")
	public ResponseEntity<Void> eliminar(@RequestHeader("Authorization") String authHeader,
			@PathVariable Long idAuditoria) {
		if (noEsAdmin(authHeader)) {
			return ResponseEntity.status(403).build();
		}
		auditoriaUseCase.eliminar(idAuditoria);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/empleado/{idEmpleado}")
	public ResponseEntity<List<AuditoriaResponseDto>> buscarPorEmpleado(
			@RequestHeader("Authorization") String authHeader, @PathVariable int idEmpleado) {
		if (noEsAdmin(authHeader)) {
			return ResponseEntity.status(403).build();
		}
		return ResponseEntity
				.ok(auditoriaUseCase.buscarPorEmpleado(idEmpleado).stream().map(mapper::toResponseDto).toList());
	}

	@GetMapping("/tabla/{tabla}")
	public ResponseEntity<List<AuditoriaResponseDto>> buscarPorTabla(@RequestHeader("Authorization") String authHeader,
			@PathVariable String tabla) {
		if (noEsAdmin(authHeader)) {
			return ResponseEntity.status(403).build();
		}
		return ResponseEntity.ok(auditoriaUseCase.buscarPorTabla(tabla).stream().map(mapper::toResponseDto).toList());
	}

	@GetMapping("/ip/{ip}")
	public ResponseEntity<List<AuditoriaResponseDto>> buscarPorIp(@RequestHeader("Authorization") String authHeader,
			@PathVariable String ip) {
		if (noEsAdmin(authHeader)) {
			return ResponseEntity.status(403).build();
		}
		return ResponseEntity.ok(auditoriaUseCase.buscarPorIp(ip).stream().map(mapper::toResponseDto).toList());
	}

	@GetMapping("/accion/{accion}")
	public ResponseEntity<List<AuditoriaResponseDto>> buscarPorAccion(@RequestHeader("Authorization") String authHeader,
			@PathVariable String accion) {
		if (noEsAdmin(authHeader)) {
			return ResponseEntity.status(403).build();
		}
		return ResponseEntity.ok(auditoriaUseCase.buscarPorAccion(accion).stream().map(mapper::toResponseDto).toList());
	}

}