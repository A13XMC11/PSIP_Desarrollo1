package com.uisrael.asistencia.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@ManyToOne
	@JoinColumn(name = "fk_rol")
	private RolEntity fkRolEntity;
	
	@OneToMany(mappedBy = "fkEmpleadoEntity")
	private List<AuditoriaEntity> listaAuditorias = new ArrayList<>();
	
	@OneToMany(mappedBy = "fkEmpleadoEntity")
	private List<ReporteDiarioEntity> listaReportes = new ArrayList<>();
}
