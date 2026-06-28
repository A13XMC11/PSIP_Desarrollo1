package com.uisrael.asistencia.presentacion.dto.response;

public class EmpleadoResponseDto {
	
	private int idEmpleado;
	private int idRol;
	private String nombreEmpleado;
	private String apellidosEmpleado;
	private String correoEmpleado;
	private String contrasenaEmpleado;
	private boolean estadoEmpleado;
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	public String getApellidosEmpleado() {
		return apellidosEmpleado;
	}
	public void setApellidosEmpleado(String apellidosEmpleado) {
		this.apellidosEmpleado = apellidosEmpleado;
	}
	public String getCorreoEmpleado() {
		return correoEmpleado;
	}
	public void setCorreoEmpleado(String correoEmpleado) {
		this.correoEmpleado = correoEmpleado;
	}
	public String getContrasenaEmpleado() {
		return contrasenaEmpleado;
	}
	public void setContrasenaEmpleado(String contrasenaEmpleado) {
		this.contrasenaEmpleado = contrasenaEmpleado;
	}
	public boolean isEstadoEmpleado() {
		return estadoEmpleado;
	}
	public void setEstadoEmpleado(boolean estadoEmpleado) {
		this.estadoEmpleado = estadoEmpleado;
	}
	
	
}
