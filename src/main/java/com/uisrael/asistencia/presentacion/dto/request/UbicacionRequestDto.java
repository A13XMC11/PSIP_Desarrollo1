package com.uisrael.asistencia.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UbicacionRequestDto {
	
	private int idUbicacion;
	@NotBlank
	private String nombreUbicacion;
	@NotBlank
	private float latitudUbicacion;
	@NotBlank
	private float longitudUbicacion;
	@NotBlank
	private float radioMetrosUbicacion;
	@NotBlank
	private boolean estadoUbicacion;
	
}
