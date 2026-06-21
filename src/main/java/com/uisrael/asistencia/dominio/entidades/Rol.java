package com.uisrael.asistencia.dominio.entidades;

import java.time.LocalDateTime;

public class Rol {
	
	private int idRol;
	private String nombreRol;
	private String descripcionRol;
	private LocalDateTime creadoRol;
	
		
	public Rol(int idRol, String nombreRol, String descripcionRol, LocalDateTime creadoRol) {
		super();
		this.idRol = idRol;
		this.nombreRol = nombreRol;
		this.descripcionRol = descripcionRol;
		this.creadoRol = creadoRol;
	}
	
	public Rol() {
		super();
	}


	public LocalDateTime getCreadoRol() {
		return creadoRol;
	}
	public void setCreadoRol(LocalDateTime creadoRol) {
		this.creadoRol = creadoRol;
	}
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
	
}
