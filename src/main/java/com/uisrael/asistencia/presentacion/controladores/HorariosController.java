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
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IHorariosUseCase;
import com.uisrael.asistencia.dominio.entidades.Auditoria;
import com.uisrael.asistencia.infraestructura.seguridad.JwtUtil;
import com.uisrael.asistencia.presentacion.dto.request.HorariosRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.HorariosResponseDto;
import com.uisrael.asistencia.presentacion.mapeadores.IHorariosDtoMapper;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asistencia/horarios")
public class HorariosController {

	private final IHorariosUseCase horariosUseCase;
	private final IHorariosDtoMapper mapper;
	private final JwtUtil jwtUtil;
	private final IAuditoriaUseCase auditoriaUseCase;

	public HorariosController(IHorariosUseCase horariosUseCase, IHorariosDtoMapper mapper, JwtUtil jwtUtil, IAuditoriaUseCase auditoriaUseCase) {
		super();
		this.horariosUseCase = horariosUseCase;
		this.mapper = mapper;
		this.jwtUtil = jwtUtil;
		this.auditoriaUseCase = auditoriaUseCase;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<HorariosResponseDto> guardar(@RequestHeader("Authorization") String authHeader,
	                                                     @Valid @RequestBody HorariosRequestDto requestHorarios,
	                                                     HttpServletRequest request) {
		Claims claims = jwtUtil.validarToken(authHeader.replace("Bearer ", ""));
		String rol = claims.get("rol", String.class);
		if (!rol.equals("ADMIN")) {
			return ResponseEntity.status(403).build();
		}
		HorariosResponseDto creado = mapper.toResponseDto(horariosUseCase.guardar(mapper.toDomain(requestHorarios)));

		Auditoria auditoria = new Auditoria();
		auditoria.setIdEmpleado(claims.get("idEmpleado", Integer.class));
		auditoria.setAccion("CREAR");
		auditoria.setTablaAfectada("horario");
		auditoria.setRegistroId(creado.getIdHorario());
		auditoria.setDetalle("Horario creado: " + creado.getNombre());
		auditoria.setIp(request.getRemoteAddr());
		auditoria.setFechaHora(LocalDateTime.now());
		auditoriaUseCase.guardar(auditoria);

		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}

	@GetMapping
	public List<HorariosResponseDto> listarTodos() {
		return horariosUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@DeleteMapping("/{idHorarios}")
	public ResponseEntity<Void> eliminar(@RequestHeader("Authorization") String authHeader,
	                                      @PathVariable int idHorarios,
	                                      HttpServletRequest request) {
		Claims claims = jwtUtil.validarToken(authHeader.replace("Bearer ", ""));
		String rol = claims.get("rol", String.class);
		if (!rol.equals("ADMIN")) {
			return ResponseEntity.status(403).build();
		}
		horariosUseCase.eliminar(idHorarios);

		Auditoria auditoria = new Auditoria();
		auditoria.setIdEmpleado(claims.get("idEmpleado", Integer.class));
		auditoria.setAccion("ELIMINAR");
		auditoria.setTablaAfectada("horario");
		auditoria.setRegistroId(idHorarios);
		auditoria.setDetalle("Horario eliminado: id=" + idHorarios);
		auditoria.setIp(request.getRemoteAddr());
		auditoria.setFechaHora(LocalDateTime.now());
		auditoriaUseCase.guardar(auditoria);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/activos")
	public List<HorariosResponseDto> listarActivos() {
		return horariosUseCase.listarHorariosActivos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/nombre/{nombre}")
	public List<HorariosResponseDto> buscarPorNombre(@PathVariable String nombre) {
		return horariosUseCase.buscarPorNombre(nombre).stream().map(mapper::toResponseDto).toList();
	}
}