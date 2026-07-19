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

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IRolUseCase;
import com.uisrael.asistencia.infraestructura.seguridad.JwtUtil;
import com.uisrael.asistencia.presentacion.dto.request.RolRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.RolResponseDto;
import com.uisrael.asistencia.presentacion.mapeadores.IRolDtoMapper;

import io.jsonwebtoken.Claims;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asistencia/rol")
public class RolController {

	private final IRolUseCase rolUseCase;
	private final IRolDtoMapper mapper;
	private final JwtUtil jwtUtil;

	public RolController(IRolUseCase rolUseCase, IRolDtoMapper mapper, JwtUtil jwtUtil) {
		this.rolUseCase = rolUseCase;
		this.mapper = mapper;
		this.jwtUtil = jwtUtil;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<RolResponseDto> guardar(@RequestHeader("Authorization") String authHeader,
			@Valid @RequestBody RolRequestDto requestRol) {
		Claims claims = jwtUtil.validarToken(authHeader.replace("Bearer ", ""));
		String rol = claims.get("rol", String.class);
		if (!rol.equals("ADMIN")) {
			return ResponseEntity.status(403).build();
		}
		RolResponseDto creado = mapper.toResponseDto(rolUseCase.guardar(mapper.toDomain(requestRol)));
		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}

	@GetMapping
	public List<RolResponseDto> listarTodos() {
		return rolUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@DeleteMapping("/{idRol}")
	public ResponseEntity<Void> eliminar(@RequestHeader("Authorization") String authHeader, @PathVariable int idRol) {
		Claims claims = jwtUtil.validarToken(authHeader.replace("Bearer ", ""));
		String rol = claims.get("rol", String.class);
		if (!rol.equals("ADMIN")) {
			return ResponseEntity.status(403).build();
		}
		rolUseCase.eliminar(idRol);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/nombre/{nombre}")
	public List<RolResponseDto> buscarPorNombre(@PathVariable String nombre) {
		return rolUseCase.buscarPorNombre(nombre).stream().map(mapper::toResponseDto).toList();
	}
}