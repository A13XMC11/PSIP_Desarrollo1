package com.uisrael.asistencia.infraestructura.repositorios;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.EmpleadoHorarioEntity;

public interface IEmpleadoHorarioJpaRepositorio extends JpaRepository<EmpleadoHorarioEntity, Integer>{
	@Query("Select eh from EmpleadoHorarioEntity eh where eh.fkEmpleadoEntity.idEmpleado=?1 and eh.estadoEmpleadoHorario=true")
    List<EmpleadoHorarioEntity> buscarHorariosActivosPorEmpleado(int idEmpleado);

    @Query("Select eh from EmpleadoHorarioEntity eh where eh.fkHorarioEntity.idHorario=?1")
    List<EmpleadoHorarioEntity> buscarPorHorario(int idHorario);
    
}
