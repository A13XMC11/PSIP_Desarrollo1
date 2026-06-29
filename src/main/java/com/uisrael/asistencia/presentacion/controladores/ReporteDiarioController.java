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
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IReporteDiarioUseCase;
import com.uisrael.asistencia.presentacion.dto.request.ReporteDiarioRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.ReporteDiarioResponseDto;
import com.uisrael.asistencia.presentacion.mapeadores.IReporteDiarioDtoMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/asistencia/reporteDiario")
public class ReporteDiarioController {

	private final IReporteDiarioUseCase reporteDiarioUseCase;
	private final IReporteDiarioDtoMapper mapper;

	public ReporteDiarioController(IReporteDiarioUseCase reporteDiarioUseCase, IReporteDiarioDtoMapper mapper) {
		super();
		this.reporteDiarioUseCase = reporteDiarioUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ReporteDiarioResponseDto guardar(@Valid @RequestBody ReporteDiarioRequestDto requestReporteDiario) {
		return mapper.toResponseDto(reporteDiarioUseCase.guardar(mapper.toDomain(requestReporteDiario)));
	}

	@GetMapping
	public List<ReporteDiarioResponseDto> listarTodos() {
		return reporteDiarioUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@DeleteMapping("/{idReporteDiario}")
	public ResponseEntity<Void> eliminar(@PathVariable int idReporteDiario) {
		reporteDiarioUseCase.eliminar(idReporteDiario);
		return ResponseEntity.noContent().build();
	}
}
