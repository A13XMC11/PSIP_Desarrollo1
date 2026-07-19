package com.uisrael.asistencia.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RolRequestDto {

	private int idRol;
	@NotBlank
	private String nombreRol;
	@NotBlank
	private String descripcionRol;
	@NotNull
	private LocalDateTime creadoRol;
}
