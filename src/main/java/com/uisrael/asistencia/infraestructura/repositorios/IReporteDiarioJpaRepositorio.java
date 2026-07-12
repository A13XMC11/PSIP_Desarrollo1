package com.uisrael.asistencia.infraestructura.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.ReporteDiarioEntity;

public interface IReporteDiarioJpaRepositorio extends JpaRepository<ReporteDiarioEntity, Integer> {

    @Query("Select r from ReporteDiarioEntity r where r.fkEmpleadoEntity.idEmpleado=?1")
    List<ReporteDiarioEntity> buscarPorEmpleado(int idEmpleado);

    @Query("Select r from ReporteDiarioEntity r where r.fkEmpleadoEntity.idEmpleado=?1 and r.fechaReporte=?2")
    List<ReporteDiarioEntity> buscarPorEmpleadoYFecha(int idEmpleado, LocalDate fecha);

    @Query("Select r from ReporteDiarioEntity r where r.tardanzaReporte=true")
    List<ReporteDiarioEntity> listarConTardanza();

    @Query("Select r from ReporteDiarioEntity r where r.marcacionImcompleta=true")
    List<ReporteDiarioEntity> listarMarcacionesIncompletas();
}