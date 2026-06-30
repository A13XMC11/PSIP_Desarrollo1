package com.uisrael.asistencia.presentacion.dto.response;

import java.time.LocalDateTime;

public class RolResponseDto {

	private int idRol;
	private String nombreRol;
	private String descripcionRol;
	private LocalDateTime creadoRol;

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public String getDescripcionRol() {
		return descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}

	public LocalDateTime getCreadoRol() {
		return creadoRol;
	}

	public void setCreadoRol(LocalDateTime creadoRol) {
		this.creadoRol = creadoRol;
	}

}
