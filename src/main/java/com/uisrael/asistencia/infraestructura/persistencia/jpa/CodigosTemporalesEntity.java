package com.uisrael.asistencia.infraestructura.persistencia.jpa;

import java.time.LocalDateTime;
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
@Table (name = "codigosTemporales")
public class CodigosTemporalesEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idCodigo;
	private int idEmpleado;
	private String codigo;
	private String tipo;
	private LocalDateTime generadoEn;
	private LocalDateTime expiraEn;
	private boolean usado;
	
	@ManyToOne
	@JoinColumn(name = "fk_empleado")
	private EmpleadoEntity fkEmpleadoEntity;
	
	@OneToMany(mappedBy = "fkCodigoEntity")
	private List<MarcacionesEntity> listaMarcaciones = new ArrayList<>();
}
