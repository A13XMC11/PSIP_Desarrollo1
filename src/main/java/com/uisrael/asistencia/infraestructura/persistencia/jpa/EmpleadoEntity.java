package com.uisrael.asistencia.infraestructura.persistencia.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "empleado")

public class EmpleadoEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idEmpleado;
	private int idRol;
	private String nombreEmpleado;
	private String apellidosEmpleado;
	private String correoEmpleado;
	private String contrasenaEmpleado;
	private boolean estadoEmpleado;
	
}
