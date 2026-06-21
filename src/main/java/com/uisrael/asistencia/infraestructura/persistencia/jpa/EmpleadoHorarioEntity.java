package com.uisrael.asistencia.infraestructura.persistencia.jpa;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "empleadoHorario")
public class EmpleadoHorarioEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idAsignacion;
	private int idEmpleado;
	private int idHorario;
	private Date fechaInicio;
	private Date fechaFin;
	private boolean estadoEmpleadoHorario;
}
