package com.uisrael.asistencia.presentacion.dto.request;

import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HorariosRequestDto {
	
	private int idHorario;
	@NotBlank
	private String nombre;
	@NotBlank
	private LocalTime horaEntrada;
	@NotBlank
	private LocalTime horaSalida;
	@NotBlank
	private int toleranciaMinutos;
	@NotBlank
	private boolean estadoHorario;
}
