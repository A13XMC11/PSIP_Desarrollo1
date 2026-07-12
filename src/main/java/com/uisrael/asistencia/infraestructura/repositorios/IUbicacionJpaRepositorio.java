package com.uisrael.asistencia.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.UbicacionEntity;

public interface IUbicacionJpaRepositorio extends JpaRepository<UbicacionEntity, Integer> {
	@Query("Select u from UbicacionEntity u where u.estadoUbicacion=true")
	List<UbicacionEntity> listarUbicacionesActivas();

	List<UbicacionEntity> findByNombreUbicacion(String nombre);
}
