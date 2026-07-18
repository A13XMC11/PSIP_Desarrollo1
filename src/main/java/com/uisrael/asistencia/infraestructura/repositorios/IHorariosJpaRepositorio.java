package com.uisrael.asistencia.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.HorariosEntity;

public interface IHorariosJpaRepositorio extends JpaRepository<HorariosEntity, Integer> {
	@Query("Select h from HorariosEntity h where h.estadoHorario=true")
	List<HorariosEntity> listarHorariosActivos();
	
	List<HorariosEntity> findByNombre(String nombre);
}
