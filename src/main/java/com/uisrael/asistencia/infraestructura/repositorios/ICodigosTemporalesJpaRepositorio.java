package com.uisrael.asistencia.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.CodigosTemporalesEntity;

public interface ICodigosTemporalesJpaRepositorio extends JpaRepository<CodigosTemporalesEntity, Integer>{

}
