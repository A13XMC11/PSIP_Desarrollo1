package com.uisrael.asistencia.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.RolEntity;

public interface IRolJpaRepositorio extends JpaRepository<RolEntity, Integer> {

    List<RolEntity> findByNombre(String nombre);
}