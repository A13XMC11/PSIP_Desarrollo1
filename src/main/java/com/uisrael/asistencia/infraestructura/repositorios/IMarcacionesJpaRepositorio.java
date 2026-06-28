package com.uisrael.asistencia.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.MarcacionesEntity;

public interface IMarcacionesJpaRepositorio extends JpaRepository<MarcacionesEntity, Integer>{
	
}
