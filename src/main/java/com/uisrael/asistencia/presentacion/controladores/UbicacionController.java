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
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IUbicacionUseCase;
import com.uisrael.asistencia.dominio.entidades.Auditoria;
import com.uisrael.asistencia.infraestructura.seguridad.JwtUtil;
import com.uisrael.asistencia.presentacion.dto.request.UbicacionRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.UbicacionResponseDto;
import com.uisrael.asistencia.presentacion.mapeadores.IUbicacionDtoMapper;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/asistencia/ubicacion")
public class UbicacionController {

	private final IUbicacionUseCase ubicacionUseCase;
	private final IUbicacionDtoMapper mapper;
	private final JwtUtil jwtUtil;
	private final IAuditoriaUseCase auditoriaUseCase;

	public UbicacionController(IUbicacionUseCase ubicacionUseCase, IUbicacionDtoMapper mapper, JwtUtil jwtUtil, IAuditoriaUseCase auditoriaUseCase) {
		super();
		this.ubicacionUseCase = ubicacionUseCase;
		this.mapper = mapper;
		this.jwtUtil = jwtUtil;
		this.auditoriaUseCase = auditoriaUseCase;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UbicacionResponseDto> guardar(@RequestHeader("Authorization") String authHeader,
	                                                      @Valid @RequestBody UbicacionRequestDto requestUbicacion,
	                                                      HttpServletRequest request) {
		Claims claims = jwtUtil.validarToken(authHeader.replace("Bearer ", ""));
		String rol = claims.get("rol", String.class);
		if (!rol.equals("ADMIN")) {
			return ResponseEntity.status(403).build();
		}
		UbicacionResponseDto creado = mapper.toResponseDto(ubicacionUseCase.guardar(mapper.toDomain(requestUbicacion)));

		Auditoria auditoria = new Auditoria();
		auditoria.setIdEmpleado(claims.get("idEmpleado", Integer.class));
		auditoria.setAccion("CREAR");
		auditoria.setTablaAfectada("Ubicacion");
		auditoria.setRegistroId(creado.getIdUbicacion());
		auditoria.setDetalle("Ubicacion creada: " + creado.getNombreUbicacion());
		auditoria.setIp(request.getRemoteAddr());
		auditoria.setFechaHora(LocalDateTime.now());
		auditoriaUseCase.guardar(auditoria);

		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}

	@GetMapping
	public List<UbicacionResponseDto> listarTodos() {
		return ubicacionUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@DeleteMapping("/{idUbicacion}")
	public ResponseEntity<Void> eliminar(@RequestHeader("Authorization") String authHeader,
	                                      @PathVariable int idUbicacion,
	                                      HttpServletRequest request) {
		Claims claims = jwtUtil.validarToken(authHeader.replace("Bearer ", ""));
		String rol = claims.get("rol", String.class);
		if (!rol.equals("ADMIN")) {
			return ResponseEntity.status(403).build();
		}
		ubicacionUseCase.eliminar(idUbicacion);

		Auditoria auditoria = new Auditoria();
		auditoria.setIdEmpleado(claims.get("idEmpleado", Integer.class));
		auditoria.setAccion("ELIMINAR");
		auditoria.setTablaAfectada("Ubicacion");
		auditoria.setRegistroId(idUbicacion);
		auditoria.setDetalle("Ubicacion eliminada: id=" + idUbicacion);
		auditoria.setIp(request.getRemoteAddr());
		auditoria.setFechaHora(LocalDateTime.now());
		auditoriaUseCase.guardar(auditoria);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/activas")
	public List<UbicacionResponseDto> listarActivas() {
		return ubicacionUseCase.listarUbicacionesActivas().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/nombre/{nombre}")
	public List<UbicacionResponseDto> buscarPorNombre(@PathVariable String nombre) {
		return ubicacionUseCase.buscarPorNombre(nombre).stream().map(mapper::toResponseDto).toList();
	}

}
