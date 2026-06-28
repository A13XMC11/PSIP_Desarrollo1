package com.uisrael.asistencia.presentacion.dto.response;

public class UbicacionResponseDto {

	private int idUbicacion;
	private String nombreUbicacion;
	private float latitudUbicacion;
	private float longitudUbicacion;
	private float radioMetrosUbicacion;
	private boolean estadoUbicacion;

	public int getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(int idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public String getNombreUbicacion() {
		return nombreUbicacion;
	}

	public void setNombreUbicacion(String nombreUbicacion) {
		this.nombreUbicacion = nombreUbicacion;
	}

	public float getLatitudUbicacion() {
		return latitudUbicacion;
	}

	public void setLatitudUbicacion(float latitudUbicacion) {
		this.latitudUbicacion = latitudUbicacion;
	}

	public float getLongitudUbicacion() {
		return longitudUbicacion;
	}

	public void setLongitudUbicacion(float longitudUbicacion) {
		this.longitudUbicacion = longitudUbicacion;
	}

	public float getRadioMetrosUbicacion() {
		return radioMetrosUbicacion;
	}

	public void setRadioMetrosUbicacion(float radioMetrosUbicacion) {
		this.radioMetrosUbicacion = radioMetrosUbicacion;
	}

	public boolean isEstadoUbicacion() {
		return estadoUbicacion;
	}

	public void setEstadoUbicacion(boolean estadoUbicacion) {
		this.estadoUbicacion = estadoUbicacion;
	}

}
