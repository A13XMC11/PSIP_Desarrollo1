package com.uisrael.asistencia.dominio.entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReporteDiario {

	private int idReporte;
	private int idEmpleado;
	private LocalDate fechaReporte;
	private LocalTime horaEntrada;
	private LocalTime horaSalida;
	private boolean tardanzaReporte;
	private int minutosTardanza;
	private boolean marcacionIncompleta;

	public ReporteDiario(int idReporte, int idEmpleado, LocalDate fechaReporte, LocalTime horaEntrada,
			LocalTime horaSalida, boolean tardanzaReporte, int minutosTardanza, boolean marcacionIncompleta) {
		super();
		this.idReporte = idReporte;
		this.idEmpleado = idEmpleado;
		this.fechaReporte = fechaReporte;
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
		this.tardanzaReporte = tardanzaReporte;
		this.minutosTardanza = minutosTardanza;
		this.marcacionIncompleta = marcacionIncompleta;

	}

	public ReporteDiario() {
		super();

	}

	public int getIdReporte() {
		return idReporte;
	}

	public void setIdReporte(int idReporte) {
		this.idReporte = idReporte;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public LocalDate getFechaReporte() {
		return fechaReporte;
	}

	public void setFechaReporte(LocalDate fechaReporte) {
		this.fechaReporte = fechaReporte;
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

	public boolean isTardanzaReporte() {
		return tardanzaReporte;
	}

	public void setTardanzaReporte(boolean tardanzaReporte) {
		this.tardanzaReporte = tardanzaReporte;
	}

	public int getMinutosTardanza() {
		return minutosTardanza;
	}

	public void setMinutosTardanza(int minutosTardanza) {
		this.minutosTardanza = minutosTardanza;
	}

	public boolean isMarcacionIncompleta() {
		return marcacionIncompleta;
	}

	public void setMarcacionIncompleta(boolean marcacionIncompleta) {
		this.marcacionIncompleta = marcacionIncompleta;
	}

}
