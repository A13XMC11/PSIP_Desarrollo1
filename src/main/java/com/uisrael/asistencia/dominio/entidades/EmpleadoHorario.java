package com.uisrael.asistencia.dominio.entidades;

import java.sql.Date;

public class EmpleadoHorario {
	private int idAsignacion;
	private int idEmpleado;
	private int idHorario;
	private Date fechaInicio;
	private Date fechaFin;
	private boolean estadoEmpleadoHorario;
	
	public EmpleadoHorario(int idAsignacion, int idEmpleado, int idHorario, Date fechaInicio, Date fechaFin,
			boolean estadoEmpleadoHorario) {
		super();
		this.idAsignacion = idAsignacion;
		this.idEmpleado = idEmpleado;
		this.idHorario = idHorario;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estadoEmpleadoHorario = estadoEmpleadoHorario;
	}

	public EmpleadoHorario() {
		super();
	}

	public int getIdAsignacion() {
		return idAsignacion;
	}

	public void setIdAsignacion(int idAsignacion) {
		this.idAsignacion = idAsignacion;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isEstadoEmpleadoHorario() {
		return estadoEmpleadoHorario;
	}

	public void setEstadoEmpleadoHorario(boolean estadoEmpleadoHorario) {
		this.estadoEmpleadoHorario = estadoEmpleadoHorario;
	}

}
