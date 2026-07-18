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

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IHorariosUseCase;
import com.uisrael.asistencia.presentacion.dto.request.HorariosRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.HorariosResponseDto;
import com.uisrael.asistencia.presentacion.mapeadores.IHorariosDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asistencia/horarios")
public class HorariosController {

	private final IHorariosUseCase horariosUseCase;
	private final IHorariosDtoMapper mapper;

	public HorariosController(IHorariosUseCase horariosUseCase, IHorariosDtoMapper mapper) {
		super();
		this.horariosUseCase = horariosUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public HorariosResponseDto guardar(@Valid @RequestBody HorariosRequestDto requestHorarios) {
		return mapper.toResponseDto(horariosUseCase.guardar(mapper.toDomain(requestHorarios)));

	}

	@GetMapping
	public List<HorariosResponseDto> listarTodos() {
		return horariosUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@DeleteMapping("/{idHorarios}")
	public ResponseEntity<Void> eliminar(@PathVariable int idHorarios) {
		horariosUseCase.eliminar(idHorarios);
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
