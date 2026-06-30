package com.uisrael.asistencia.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data

public class AuditoriaRequestDto {

	private long idAuditoria;
	@NotBlank
	private int idEmpleado;
	@NotBlank
	private String accion;
	@NotBlank
	private String tablaAfectada;
	@NotBlank
	private int registroId;
	@NotBlank
	private String detalle;
	@NotBlank
	private String ip;
	@NotBlank
	private LocalDateTime fechaHora;
}
