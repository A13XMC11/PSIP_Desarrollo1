package com.uisrael.asistencia.dominio.entidades;

import java.time.LocalTime;
import java.util.Date;

public class Marcaciones {

	private int idMarcaciones;
	private int idEmpleado;
	private int idCodigo;
	private int idUbicacion;
	private String tipo;
	private Date fechaMarcacion;
	private LocalTime horaMarcacion;
	private float latitud;
	private float longitud;
	private boolean dentroRango;
	private boolean dentroHorario;
	private boolean valida;
	private String observacion;

	public Marcaciones() {
		super();
	}

	public Marcaciones(int idMarcaciones, int idEmpleado, int idCodigo, int idUbicacion, String tipo,
			Date fechaMarcacion, LocalTime horaMarcacion, float latitud, float longitud, boolean dentroRango,
			boolean dentroHorario, boolean valida, String observacion) {
		super();
		this.idMarcaciones = idMarcaciones;
		this.idEmpleado = idEmpleado;
		this.idCodigo = idCodigo;
		this.idUbicacion = idUbicacion;
		this.tipo = tipo;
		this.fechaMarcacion = fechaMarcacion;
		this.horaMarcacion = horaMarcacion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.dentroRango = dentroRango;
		this.dentroHorario = dentroHorario;
		this.valida = valida;
		this.observacion = observacion;
	}

	public int getIdMarcaciones() {
		return idMarcaciones;
	}

	public void setIdMarcaciones(int idMarcaciones) {
		this.idMarcaciones = idMarcaciones;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getIdCodigo() {
		return idCodigo;
	}

	public void setIdCodigo(int idCodigo) {
		this.idCodigo = idCodigo;
	}

	public int getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(int idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFechaMarcacion() {
		return fechaMarcacion;
	}

	public void setFechaMarcacion(Date fechaMarcacion) {
		this.fechaMarcacion = fechaMarcacion;
	}

	public LocalTime getHoraMarcacion() {
		return horaMarcacion;
	}

	public void setHoraMarcacion(LocalTime horaMarcacion) {
		this.horaMarcacion = horaMarcacion;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public boolean isDentroRango() {
		return dentroRango;
	}

	public void setDentroRango(boolean dentroRango) {
		this.dentroRango = dentroRango;
	}

	public boolean isDentroHorario() {
		return dentroHorario;
	}

	public void setDentroHorario(boolean dentroHorario) {
		this.dentroHorario = dentroHorario;
	}

	public boolean isValida() {
		return valida;
	}

	public void setValida(boolean valida) {
		this.valida = valida;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
