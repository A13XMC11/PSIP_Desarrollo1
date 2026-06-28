package com.uisrael.asistencia.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmpleadoRequestDto {
	
	private int idEmpleado;
	@NotBlank
	private int idRol;
	@NotBlank
	private String nombreEmpleado;
	@NotBlank
	private String apellidosEmpleado;
	@NotBlank
	private String correoEmpleado;
	@NotBlank
	private String contrasenaEmpleado;
	@NotBlank
	private boolean estadoEmpleado;
}
