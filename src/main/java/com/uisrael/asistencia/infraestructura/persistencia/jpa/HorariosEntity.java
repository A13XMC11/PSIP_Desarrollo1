package com.uisrael.asistencia.infraestructura.persistencia.jpa;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "horario") 
public class HorariosEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idHorario;
	private String nombre;
	private LocalTime horaEntrada;
	private LocalTime horaSalida;
	private int toleranciaMinutos;
	private boolean estadoHorario;
	
	@OneToMany(mappedBy = "fkHorarioEntity")
	private List<EmpleadoHorarioEntity> listaAsignaciones = new ArrayList<>();
}
