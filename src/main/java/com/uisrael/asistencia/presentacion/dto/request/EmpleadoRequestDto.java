package com.uisrael.asistencia.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmpleadoRequestDto {
	
	private int idEmpleado;
	@NotNull
	private int idRol;
	@NotBlank
	private String nombreEmpleado;
	@NotBlank
	private String apellidosEmpleado;
	@NotBlank
	private String correoEmpleado;
	@NotBlank
	private String contrasenaEmpleado;
	
	private boolean estadoEmpleado;
}
