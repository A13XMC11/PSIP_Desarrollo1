package com.uisrael.asistencia.infraestructura.persistencia.jpa;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Auditoria")
public class AuditoriaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long idAuditoria;
	private int idEmpleado;
	private String accion;
	private String tablaAfectada;
	private int registroId;
	private String detalle;
	private String ip;
	private LocalDateTime fechaHora;
	
}
