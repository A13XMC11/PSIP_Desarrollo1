package com.uisrael.asistencia.infraestructura.persistencia.jpa;

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
@Table(name = "Ubicacion")
public class UbicacionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUbicacion;
	private String nombreUbicacion;
	private float latitudUbicacion;
	private float longitudUbicacion;
	private float radioMetrosUbicacion;
	private boolean estadoUbicacion;
	
	@OneToMany(mappedBy = "fkUbicacionEntity")
	private List<MarcacionesEntity> listaMarcaciones = new ArrayList<>();
	
}
