package com.uisrael.asistencia.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.UbicacionEntity;

public interface IUbicacionJpaRepositorio extends JpaRepository<UbicacionEntity, Integer>{

}
