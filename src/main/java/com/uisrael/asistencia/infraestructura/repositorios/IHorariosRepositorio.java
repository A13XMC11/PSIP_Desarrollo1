package com.uisrael.asistencia.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.HorariosEntity;

public interface IHorariosRepositorio extends JpaRepository<HorariosEntity, Integer> {

}
