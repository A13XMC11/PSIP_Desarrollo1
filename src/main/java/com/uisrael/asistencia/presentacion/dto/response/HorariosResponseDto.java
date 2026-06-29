package com.uisrael.asistencia.presentacion.dto.response;

import java.time.LocalTime;

public class HorariosResponseDto {
	
	private int idHorario;
	private String nombre;
	private LocalTime horaEntrada;
	private LocalTime horaSalida;
	private int toleranciaMinutos;
	private boolean estadoHorario;
	
	public int getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public LocalTime getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}
	public int getToleranciaMinutos() {
		return toleranciaMinutos;
	}
	public void setToleranciaMinutos(int toleranciaMinutos) {
		this.toleranciaMinutos = toleranciaMinutos;
	}
	public boolean isEstadoHorario() {
		return estadoHorario;
	}
	public void setEstadoHorario(boolean estadoHorario) {
		this.estadoHorario = estadoHorario;
	}
	
}
