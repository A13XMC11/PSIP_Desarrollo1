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
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IAuditoriaUseCase;
import com.uisrael.asistencia.presentacion.dto.request.AuditoriaRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.AuditoriaResponseDto;
import com.uisrael.asistencia.presentacion.mapeadores.IAuditoriaDtoMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/asistencia/auditoria")
public class AuditoriaController {

	private final IAuditoriaUseCase auditoriaUseCase;
	private final IAuditoriaDtoMapper mapper;

	public AuditoriaController(IAuditoriaUseCase auditoriaUseCase, IAuditoriaDtoMapper mapper) {
		super();
		this.auditoriaUseCase = auditoriaUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AuditoriaResponseDto guardar(@Valid @RequestBody AuditoriaRequestDto requestAuditoria) {
		return mapper.toResponseDto(auditoriaUseCase.guardar(mapper.toDomain(requestAuditoria)));
	}

	@GetMapping
	public List<AuditoriaResponseDto> listarTodos() {
		return auditoriaUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}
	
	@DeleteMapping("/{idAuditoria}")
	public ResponseEntity<Void> eliminar(@PathVariable int idAuditoria)
	{
		auditoriaUseCase.eliminar(idAuditoria);
		return ResponseEntity.noContent().build();
	}
	

}
