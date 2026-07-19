package com.uisrael.asistencia.presentacion.controladores;

import java.time.LocalDateTime;
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
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IRolUseCase;
import com.uisrael.asistencia.dominio.entidades.Auditoria;
import com.uisrael.asistencia.infraestructura.seguridad.JwtUtil;
import com.uisrael.asistencia.presentacion.dto.request.RolRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.RolResponseDto;
import com.uisrael.asistencia.presentacion.mapeadores.IRolDtoMapper;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asistencia/rol")
public class RolController {

	private final IRolUseCase rolUseCase;
	private final IRolDtoMapper mapper;
	private final JwtUtil jwtUtil;
	private final IAuditoriaUseCase auditoriaUseCase;

	public RolController(IRolUseCase rolUseCase, IRolDtoMapper mapper, JwtUtil jwtUtil,
			IAuditoriaUseCase auditoriaUseCase) {
		this.rolUseCase = rolUseCase;
		this.mapper = mapper;
		this.jwtUtil = jwtUtil;
		this.auditoriaUseCase = auditoriaUseCase;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<RolResponseDto> guardar(@RequestHeader("Authorization") String authHeader,
			@Valid @RequestBody RolRequestDto requestRol, HttpServletRequest request) {
		Claims claims = jwtUtil.validarToken(authHeader.replace("Bearer ", ""));
		String rol = claims.get("rol", String.class);
		if (!rol.equals("ADMIN")) {
			return ResponseEntity.status(403).build();
		}
		RolResponseDto creado = mapper.toResponseDto(rolUseCase.guardar(mapper.toDomain(requestRol)));

		Auditoria auditoria = new Auditoria();
		auditoria.setIdEmpleado(claims.get("idEmpleado", Integer.class));
		auditoria.setAccion("CREAR");
		auditoria.setTablaAfectada("roles");
		auditoria.setRegistroId(creado.getIdRol());
		auditoria.setDetalle("Rol creado: " + creado.getNombreRol());
		auditoria.setIp(request.getRemoteAddr());
		auditoria.setFechaHora(LocalDateTime.now());
		auditoriaUseCase.guardar(auditoria);

		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}

	@GetMapping
	public List<RolResponseDto> listarTodos() {
		return rolUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@DeleteMapping("/{idRol}")
	public ResponseEntity<Void> eliminar(@RequestHeader("Authorization") String authHeader, @PathVariable int idRol,
			HttpServletRequest request) {
		Claims claims = jwtUtil.validarToken(authHeader.replace("Bearer ", ""));
		String rol = claims.get("rol", String.class);
		if (!rol.equals("ADMIN")) {
			return ResponseEntity.status(403).build();
		}
		rolUseCase.eliminar(idRol);

		Auditoria auditoria = new Auditoria();
		auditoria.setIdEmpleado(claims.get("idEmpleado", Integer.class));
		auditoria.setAccion("ELIMINAR");
		auditoria.setTablaAfectada("roles");
		auditoria.setRegistroId(idRol);
		auditoria.setDetalle("Rol eliminado: id=" + idRol);
		auditoria.setIp(request.getRemoteAddr());
		auditoria.setFechaHora(LocalDateTime.now());
		auditoriaUseCase.guardar(auditoria);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/nombre/{nombre}")
	public List<RolResponseDto> buscarPorNombre(@PathVariable String nombre) {
		return rolUseCase.buscarPorNombre(nombre).stream().map(mapper::toResponseDto).toList();
	}
}