package com.uisrael.asistencia.infraestructura.persistencia.jpa;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "marcaciones")

public class MarcacionesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMarcaciones;
	private int idEmpleado;
	private int idCodigo;
	private int idUbicacion;
	private String tipo;
	private LocalDate fechaMarcacion;
	private LocalTime horaMarcacion;
	private float latitud;
	private float longitud;
	private boolean dentroRango;
	private boolean dentroHorario;
	private boolean valida;
	private String observacion;
	
	
}
