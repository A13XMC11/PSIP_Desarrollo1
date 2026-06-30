package com.uisrael.asistencia.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.AuditoriaEntity;

public interface IAuditoriaJpaRepositorio extends JpaRepository<AuditoriaEntity, Long>{

}
