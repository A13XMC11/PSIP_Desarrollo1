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

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IMarcacionesUsaCase;
import com.uisrael.asistencia.presentacion.dto.request.MarcacionesRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.MarcacionesResponseDto;
import com.uisrael.asistencia.presentacion.mapeadores.IMarcacionesDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asistencia/marcaciones")
public class MarcacionesController {

	private final IMarcacionesUsaCase marcacionesUseCase;
	private final IMarcacionesDtoMapper mapper;

	public MarcacionesController(IMarcacionesUsaCase marcacionesUseCase, IMarcacionesDtoMapper mapper) {
		super();
		this.marcacionesUseCase = marcacionesUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MarcacionesResponseDto guardar(@Valid @RequestBody MarcacionesRequestDto requestMarcaciones) {
		return mapper.toResponseDto(marcacionesUseCase.guardar(mapper.toDomain(requestMarcaciones)));
	}
	@GetMapping
	public List<MarcacionesResponseDto> listarTodos(){
		return marcacionesUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}
	@DeleteMapping("/{idMarcaciones}")
	public ResponseEntity<Void> eliminar(@PathVariable int idMarcaciones){
		marcacionesUseCase.eliminar(idMarcaciones);
		return ResponseEntity.noContent().build();
	}

}
