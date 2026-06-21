package com.uisrael.asistencia.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.RolEntity;

public interface IRolRepositorio extends JpaRepository<RolEntity, Integer>{

}
