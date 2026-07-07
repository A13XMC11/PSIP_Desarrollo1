package com.uisrael.asistencia.dominio.entidades;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.RolEntity;

public class Empleado {

	private int idEmpleado;
	private RolEntity fkRolEntity;
	private String nombreEmpleado;
	private String apellidosEmpleado;
	private String correoEmpleado;
	private String contrasenaEmpleado;
	private boolean estadoEmpleado;

	public Empleado(int idEmpleado, RolEntity fkRolEntity, String nombreEmpleado, String apellidosEmpleado,
			String correoEmpleado, String contrasenaEmpleado, boolean estadoEmpleado) {
		super();
		this.idEmpleado = idEmpleado;
		this.fkRolEntity = fkRolEntity;
		this.nombreEmpleado = nombreEmpleado;
		this.apellidosEmpleado = apellidosEmpleado;
		this.correoEmpleado = correoEmpleado;
		this.contrasenaEmpleado = contrasenaEmpleado;
		this.estadoEmpleado = estadoEmpleado;
	}

	public Empleado() {
		super();
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public RolEntity getFkRolEntity() {
		return fkRolEntity;
	}

	public void setFkRolEntity(RolEntity fkRolEntity) {
		this.fkRolEntity = fkRolEntity;
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
