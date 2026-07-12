package com.uisrael.asistencia.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IEmpleadoUseCase;
import com.uisrael.asistencia.dominio.entidades.Empleado;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.RolEntity;
import com.uisrael.asistencia.presentacion.dto.request.EmpleadoRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.EmpleadoResponseDto;
import com.uisrael.asistencia.presentacion.mapeadores.IEmpleadoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asistencia/empleado")
public class EmpleadoController {
	private final IEmpleadoUseCase empleadoUseCase;
	private final IEmpleadoDtoMapper mapper;

	public EmpleadoController(IEmpleadoUseCase empleadoUseCase, IEmpleadoDtoMapper mapper) {
		super();
		this.empleadoUseCase = empleadoUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EmpleadoResponseDto guardar(@Valid @RequestBody EmpleadoRequestDto requestEmpleado) {
		Empleado empleado = mapper.toDomain(requestEmpleado);
		RolEntity rol = new RolEntity();
		rol.setIdRol(requestEmpleado.getIdRol());
		empleado.setFkRolEntity(rol);
		return mapper.toResponseDto(empleadoUseCase.guardar(empleado));
	}

	@GetMapping
	public List<EmpleadoResponseDto> listarTodos() {
		return empleadoUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@DeleteMapping("/{idEmpleado}")
	public ResponseEntity<Void> eliminar(@PathVariable int idEmpleado) {
		empleadoUseCase.eliminar(idEmpleado);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/correo/{correo}")
	public List<EmpleadoResponseDto> buscarPorCorreo(@PathVariable String correo) {
		return empleadoUseCase.findByCorreoEmpleado(correo).stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/activos")
	public List<EmpleadoResponseDto> listarActivos() {
		return empleadoUseCase.listarEmpleadosActivos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/rol/{idRol}")
	public List<EmpleadoResponseDto> buscarPorRol(@PathVariable int idRol) {
		return empleadoUseCase.buscarPorRol(idRol).stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/nombre/{nombre}")
	public List<EmpleadoResponseDto> buscarPorNombre(@PathVariable String nombre) {
		return empleadoUseCase.buscarPorNombre(nombre).stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/apellido/{apellido}")
	public List<EmpleadoResponseDto> buscarPorApellido(@PathVariable String apellido) {
		return empleadoUseCase.buscarPorApellido(apellido).stream().map(mapper::toResponseDto).toList();
	}
}
