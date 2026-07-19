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
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IEmpleadoHorarioUseCase;
import com.uisrael.asistencia.dominio.entidades.Auditoria;
import com.uisrael.asistencia.infraestructura.seguridad.JwtUtil;
import com.uisrael.asistencia.presentacion.dto.request.EmpleadoHorarioRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.EmpleadoHorarioResponseDto;
import com.uisrael.asistencia.presentacion.mapeadores.IEmpleadoHorarioDtoMapper;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asistencia/empleadoHorario")
public class EmpleadoHorarioController {
	
	private final IEmpleadoHorarioUseCase empleadoHorarioUseCase;
	private final IEmpleadoHorarioDtoMapper mapper;
	private final JwtUtil jwtUtil;
	private final IAuditoriaUseCase auditoriaUseCase;

	public EmpleadoHorarioController(IEmpleadoHorarioUseCase empleadoHorarioUseCase, IEmpleadoHorarioDtoMapper mapper, JwtUtil jwtUtil, IAuditoriaUseCase auditoriaUseCase) {
		super();
		this.empleadoHorarioUseCase = empleadoHorarioUseCase;
		this.mapper = mapper;
		this.jwtUtil = jwtUtil;
		this.auditoriaUseCase = auditoriaUseCase;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<EmpleadoHorarioResponseDto> guardar(@RequestHeader("Authorization") String authHeader,
	                                                            @Valid @RequestBody EmpleadoHorarioRequestDto requestEmpleadoHorario,
	                                                            HttpServletRequest request) {
		Claims claims = jwtUtil.validarToken(authHeader.replace("Bearer ", ""));
		String rol = claims.get("rol", String.class);
		if (!rol.equals("ADMIN")) {
			return ResponseEntity.status(403).build();
		}
		EmpleadoHorarioResponseDto creado = mapper.toResponseDto(empleadoHorarioUseCase.guardar(mapper.toDomain(requestEmpleadoHorario)));

		Auditoria auditoria = new Auditoria();
		auditoria.setIdEmpleado(claims.get("idEmpleado", Integer.class));
		auditoria.setAccion("CREAR");
		auditoria.setTablaAfectada("empleadoHorario");
		auditoria.setRegistroId(creado.getIdAsignacion());
		auditoria.setDetalle("Asignacion creada: empleado=" + creado.getIdEmpleado() + ", horario=" + creado.getIdHorario());
		auditoria.setIp(request.getRemoteAddr());
		auditoria.setFechaHora(LocalDateTime.now());
		auditoriaUseCase.guardar(auditoria);

		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}

	@GetMapping
	public List<EmpleadoHorarioResponseDto> listarTodos()
	{
		return empleadoHorarioUseCase.listarTodos().stream()
				.map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idEmpleadoHorario}")
	public ResponseEntity<Void> eliminar(@RequestHeader("Authorization") String authHeader,
	                                      @PathVariable int idEmpleadoHorario,
	                                      HttpServletRequest request){
		Claims claims = jwtUtil.validarToken(authHeader.replace("Bearer ", ""));
		String rol = claims.get("rol", String.class);
		if (!rol.equals("ADMIN")) {
			return ResponseEntity.status(403).build();
		}
		empleadoHorarioUseCase.eliminar(idEmpleadoHorario);

		Auditoria auditoria = new Auditoria();
		auditoria.setIdEmpleado(claims.get("idEmpleado", Integer.class));
		auditoria.setAccion("ELIMINAR");
		auditoria.setTablaAfectada("empleadoHorario");
		auditoria.setRegistroId(idEmpleadoHorario);
		auditoria.setDetalle("Asignacion eliminada: id=" + idEmpleadoHorario);
		auditoria.setIp(request.getRemoteAddr());
		auditoria.setFechaHora(LocalDateTime.now());
		auditoriaUseCase.guardar(auditoria);

		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/empleado/{idEmpleado}/activos")
    public List<EmpleadoHorarioResponseDto> buscarHorariosActivos(@PathVariable int idEmpleado) {
        return empleadoHorarioUseCase.buscarHorariosActivosPorEmpleado(idEmpleado).stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/horario/{idHorario}")
    public List<EmpleadoHorarioResponseDto> buscarPorHorario(@PathVariable int idHorario) {
        return empleadoHorarioUseCase.buscarPorHorario(idHorario).stream().map(mapper::toResponseDto).toList();
    }
}