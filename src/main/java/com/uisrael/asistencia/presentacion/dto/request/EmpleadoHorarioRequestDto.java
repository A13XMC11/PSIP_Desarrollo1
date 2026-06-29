package com.uisrael.asistencia.presentacion.dto.request;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmpleadoHorarioRequestDto {
	private int idAsignacion;
	@NotBlank
	private int idEmpleado;
	@NotBlank
	private int idHorario;
	@NotBlank
	private Date fechaInicio;
	@NotBlank
	private Date fechaFin;
	@NotBlank
	private boolean estadoEmpleadoHorario;
}
