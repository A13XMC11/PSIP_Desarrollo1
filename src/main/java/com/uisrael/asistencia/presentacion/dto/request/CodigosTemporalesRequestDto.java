package com.uisrael.asistencia.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CodigosTemporalesRequestDto {
	
	private int idCodigo;
	@NotBlank
	private int idEmpleado;
	@NotBlank
	private String codigo;
	@NotBlank
	private String tipo;
	@NotBlank
	private LocalDateTime generadoEn;
	@NotBlank
	private LocalDateTime expiraEn;
	@NotBlank
	private boolean usado;
}
