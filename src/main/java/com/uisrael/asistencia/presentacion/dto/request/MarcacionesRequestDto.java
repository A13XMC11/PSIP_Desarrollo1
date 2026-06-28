package com.uisrael.asistencia.presentacion.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class MarcacionesRequestDto {
	private int idMarcaciones;
	@NotBlank
	private int idEmpleado;
	@NotBlank
	private int idCodigo;
	@NotBlank
	private int idUbicacion;
	@NotBlank
	private String tipo;
	@NotBlank
	private LocalDate fechaMarcacion;
	@NotBlank
	private LocalTime horaMarcacion;
	@NotBlank
	private float latitud;
	@NotBlank
	private float longitud;
	@NotBlank
	private boolean dentroRango;
	@NotBlank
	private boolean dentroHorario;
	@NotBlank
	private boolean valida;
	@NotBlank
	private String observacion;
}
