package com.uisrael.asistencia.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.EmpleadoHorarioEntity;

public interface IEmpleadoHorarioRepositorio extends JpaRepository<EmpleadoHorarioEntity, Integer>{

}
