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

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IEmpleadoHorarioUseCase;
import com.uisrael.asistencia.presentacion.dto.request.EmpleadoHorarioRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.EmpleadoHorarioResponseDto;
import com.uisrael.asistencia.presentacion.mapeadores.IEmpleadoHorarioDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asistencia/empleadoHorario")
public class EmpleadoHorarioController {
	
	private final IEmpleadoHorarioUseCase empleadoHorarioUseCase;
	private final IEmpleadoHorarioDtoMapper mapper;

	public EmpleadoHorarioController(IEmpleadoHorarioUseCase empleadoHorarioUseCase, IEmpleadoHorarioDtoMapper mapper) {
		super();
		this.empleadoHorarioUseCase = empleadoHorarioUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EmpleadoHorarioResponseDto guardar(@Valid @RequestBody EmpleadoHorarioRequestDto requestEmpleadoHorario) {
		return mapper.toResponseDto(empleadoHorarioUseCase.guardar(mapper.toDomain(requestEmpleadoHorario)));

	}

	@GetMapping
	public List<EmpleadoHorarioResponseDto> listarTodos()
	{
		return empleadoHorarioUseCase.listarTodos().stream()
				.map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idEmpleadoHorario}")
	public ResponseEntity<Void> eliminar(@PathVariable int idEmpleadoHorario){
		empleadoHorarioUseCase.eliminar(idEmpleadoHorario);
		return ResponseEntity.noContent().build();
	}
}
