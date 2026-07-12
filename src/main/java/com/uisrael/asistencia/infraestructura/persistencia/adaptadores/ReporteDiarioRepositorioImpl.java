package com.uisrael.asistencia.infraestructura.persistencia.adaptadores;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.ReporteDiario;
import com.uisrael.asistencia.dominio.repositorio.IReporteDiarioRepositorio;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IReporteDiarioJpaMapper;
import com.uisrael.asistencia.infraestructura.repositorios.IReporteDiarioJpaRepositorio;

public class ReporteDiarioRepositorioImpl implements IReporteDiarioRepositorio {

    private final IReporteDiarioJpaRepositorio jpaRepositorio;
    private final IReporteDiarioJpaMapper entityMapper;

    public ReporteDiarioRepositorioImpl(IReporteDiarioJpaRepositorio jpaRepositorio, IReporteDiarioJpaMapper entityMapper) {
        this.jpaRepositorio = jpaRepositorio;
        this.entityMapper = entityMapper;
    }

    @Override
    public ReporteDiario guardar(ReporteDiario nuevoReporteDiario) {
        return entityMapper.toDomain(jpaRepositorio.save(entityMapper.toEntity(nuevoReporteDiario)));
    }

    @Override
    public Optional<ReporteDiario> buscarPorId(int idReporteDiario) {
        return jpaRepositorio.findById(idReporteDiario).map(entityMapper::toDomain);
    }

    @Override
    public List<ReporteDiario> listarTodos() {
        return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
    }

    @Override
    public void eliminar(int idReporteDiario) {
        jpaRepositorio.deleteById(idReporteDiario);
    }

    @Override
    public List<ReporteDiario> buscarPorEmpleado(int idEmpleado) {
        return jpaRepositorio.buscarPorEmpleado(idEmpleado).stream().map(entityMapper::toDomain).toList();
    }

    @Override
    public List<ReporteDiario> buscarPorEmpleadoYFecha(int idEmpleado, LocalDate fecha) {
        return jpaRepositorio.buscarPorEmpleadoYFecha(idEmpleado, fecha).stream().map(entityMapper::toDomain).toList();
    }

    @Override
    public List<ReporteDiario> listarConTardanza() {
        return jpaRepositorio.listarConTardanza().stream().map(entityMapper::toDomain).toList();
    }

    @Override
    public List<ReporteDiario> listarMarcacionesIncompletas() {
        return jpaRepositorio.listarMarcacionesIncompletas().stream().map(entityMapper::toDomain).toList();
    }
}