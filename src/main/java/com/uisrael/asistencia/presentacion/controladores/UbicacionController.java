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

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IUbicacionUseCase;
import com.uisrael.asistencia.presentacion.dto.request.UbicacionRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.UbicacionResponseDto;
import com.uisrael.asistencia.presentacion.mapeadores.IUbicacionDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/asistencia/ubicacion")
public class UbicacionController {

	private final IUbicacionUseCase ubicacionUseCase;
	private final IUbicacionDtoMapper mapper;

	public UbicacionController(IUbicacionUseCase ubicacionUseCase, IUbicacionDtoMapper mapper) {
		super();
		this.ubicacionUseCase = ubicacionUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UbicacionResponseDto guardar(@Valid @RequestBody UbicacionRequestDto requestUbicacion) {
		return mapper.toResponseDto(ubicacionUseCase.guardar(mapper.toDomain(requestUbicacion)));
	}

	@GetMapping
	public List<UbicacionResponseDto> listarTodos() {
		return ubicacionUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@DeleteMapping("/{idUbicacion}")
	public ResponseEntity<Void> eliminar(@PathVariable int idUbicacion) {
		ubicacionUseCase.eliminar(idUbicacion);
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
