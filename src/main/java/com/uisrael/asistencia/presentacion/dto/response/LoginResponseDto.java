package com.uisrael.asistencia.presentacion.dto.response;

public class LoginResponseDto {

	private String token;
	private int idEmpleado;
	private String nombre;
	private String rol;

	public LoginResponseDto(String token, int idEmpleado, String nombre, String rol) {
		this.token = token;
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.rol = rol;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
