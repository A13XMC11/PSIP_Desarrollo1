package com.uisrael.asistencia.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.EmpleadoEntity;

public interface IEmpleadoJpaRepositorio extends JpaRepository<EmpleadoEntity, Integer>{

}
