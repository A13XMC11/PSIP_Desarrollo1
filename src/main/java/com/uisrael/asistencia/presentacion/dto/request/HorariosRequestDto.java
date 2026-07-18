package com.uisrael.asistencia.presentacion.dto.request;

import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HorariosRequestDto {
	
	private int idHorario;
	@NotBlank
	private String nombre;
	@NotNull
	private LocalTime horaEntrada;
	@NotNull
	private LocalTime horaSalida;
	@NotNull
	private int toleranciaMinutos;
	private boolean estadoHorario;
}
