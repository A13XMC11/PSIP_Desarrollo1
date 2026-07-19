package com.uisrael.asistencia.presentacion.dto.request;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmpleadoHorarioRequestDto {
	
	private int idAsignacion;
	@NotNull
	private int idEmpleado;
	@NotNull
	private int idHorario;
	@NotNull
	private Date fechaInicio;
	@NotNull
	private Date fechaFin;
	private boolean estadoEmpleadoHorario;
}
