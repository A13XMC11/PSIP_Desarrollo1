package com.uisrael.asistencia.infraestructura.persistencia.jpa;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ReporteDiario")

public class ReporteDiarioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReporte;
	private int idEmpelado;
	private LocalDate fechaReporte;
	private LocalTime horaEntrada;
	private LocalTime horaSalida;
	private boolean tardanzaReporte;
	private int minutosTardanza;
	private boolean marcacionImcompleta;

}
