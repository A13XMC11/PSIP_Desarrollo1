package com.uisrael.asistencia.dominio.entidades;

import java.time.LocalTime;
import java.util.Date;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.CodigosTemporalesEntity;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.EmpleadoEntity;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.UbicacionEntity;

public class Marcaciones {

	private int idMarcaciones;
	private EmpleadoEntity fkEmpleadoEntity;
	private CodigosTemporalesEntity fkCodigoEntity;
	private UbicacionEntity fkUbicacionEntity;
	private String tipo;
	private Date fechaMarcacion;
	private LocalTime horaMarcacion;
	private float latitud;
	private float longitud;
	private boolean dentroRango;
	private boolean dentroHorario;
	private boolean valida;
	private String observacion;

	public Marcaciones(int idMarcaciones, EmpleadoEntity fkEmpleadoEntity, CodigosTemporalesEntity fkCodigoEntity,
			UbicacionEntity fkUbicacionEntity, String tipo, Date fechaMarcacion, LocalTime horaMarcacion, float latitud,
			float longitud, boolean dentroRango, boolean dentroHorario, boolean valida, String observacion) {
		super();
		this.idMarcaciones = idMarcaciones;
		this.fkEmpleadoEntity = fkEmpleadoEntity;
		this.fkCodigoEntity = fkCodigoEntity;
		this.fkUbicacionEntity = fkUbicacionEntity;
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

	public Marcaciones() {
		super();
	}

	public int getIdMarcaciones() {
		return idMarcaciones;
	}

	public void setIdMarcaciones(int idMarcaciones) {
		this.idMarcaciones = idMarcaciones;
	}

	public EmpleadoEntity getFkEmpleadoEntity() {
		return fkEmpleadoEntity;
	}

	public void setFkEmpleadoEntity(EmpleadoEntity fkEmpleadoEntity) {
		this.fkEmpleadoEntity = fkEmpleadoEntity;
	}

	public CodigosTemporalesEntity getFkCodigoEntity() {
		return fkCodigoEntity;
	}

	public void setFkCodigoEntity(CodigosTemporalesEntity fkCodigoEntity) {
		this.fkCodigoEntity = fkCodigoEntity;
	}

	public UbicacionEntity getFkUbicacionEntity() {
		return fkUbicacionEntity;
	}

	public void setFkUbicacionEntity(UbicacionEntity fkUbicacionEntity) {
		this.fkUbicacionEntity = fkUbicacionEntity;
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
