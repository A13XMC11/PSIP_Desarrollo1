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

import com.uisrael.asistencia.aplicacion.casosuso.entrada.ICodigosTemporalesUseCase;
import com.uisrael.asistencia.presentacion.dto.request.CodigosTemporalesRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.CodigosTemporalesResponseDto;
import com.uisrael.asistencia.presentacion.mapeadores.ICodigosTemporalesDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asistencia/codigosTemporales")
public class CodigosTemporalesController {
	private final ICodigosTemporalesUseCase codigosTemporalesUseCase;
	private final ICodigosTemporalesDtoMapper mapper;

	public CodigosTemporalesController(ICodigosTemporalesUseCase codigosTemporalesUseCase,
			ICodigosTemporalesDtoMapper mapper) {
		super();
		this.codigosTemporalesUseCase = codigosTemporalesUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CodigosTemporalesResponseDto guardar(@Valid @RequestBody CodigosTemporalesRequestDto requestCodigosTemporales) {
		return mapper.toResponseDto(codigosTemporalesUseCase.guardar(mapper.toDomain(requestCodigosTemporales)));

	}

	@GetMapping
	public List<CodigosTemporalesResponseDto> listarTodos()
	{
		return codigosTemporalesUseCase.listarTodos().stream()
				.map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idCodigosTemporales}")
	public ResponseEntity<Void> eliminar(@PathVariable int idCodigosTemporales){
		codigosTemporalesUseCase.eliminar(idCodigosTemporales);
		return ResponseEntity.noContent().build();
	}
}
