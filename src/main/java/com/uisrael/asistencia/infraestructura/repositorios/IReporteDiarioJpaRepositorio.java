package com.uisrael.asistencia.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.ReporteDiarioEntity;

public interface IReporteDiarioJpaRepositorio extends JpaRepository<ReporteDiarioEntity, Integer>{

}
