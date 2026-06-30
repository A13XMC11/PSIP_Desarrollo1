package com.uisrael.asistencia.presentacion.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReporteDiarioRequestDto {

	private int idReporte;
	@NotBlank
	private int idEmpleado;
	@NotBlank
	private LocalDate fechaReporte;
	@NotBlank
	private LocalTime horaEntrada;
	@NotBlank
	private LocalTime horaSalida;
	@NotBlank
	private boolean tardanzaReporte;
	@NotBlank
	private int minutosTardanza;
	@NotBlank
	private boolean marcacionIncompleta;
}
