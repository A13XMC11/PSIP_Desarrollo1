package com.uisrael.asistencia.aplicacion.casosuso.impl;

import java.time.LocalDate;
import java.util.List;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IReporteDiarioUseCase;
import com.uisrael.asistencia.dominio.entidades.ReporteDiario;
import com.uisrael.asistencia.dominio.repositorio.IReporteDiarioRepositorio;

public class ReporteDiarioUseCaseImpl implements IReporteDiarioUseCase {

    private final IReporteDiarioRepositorio repositorio;

    public ReporteDiarioUseCaseImpl(IReporteDiarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public ReporteDiario guardar(ReporteDiario nuevoReporteDiario) {
        return repositorio.guardar(nuevoReporteDiario);
    }

    @Override
    public ReporteDiario buscarPorId(int idReporteDiario) {
        return repositorio.buscarPorId(idReporteDiario).orElseThrow(() -> new RuntimeException("No se encontro ReporteDiario"));
    }

    @Override
    public List<ReporteDiario> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int idReporteDiario) {
        repositorio.eliminar(idReporteDiario);
    }

    @Override
    public List<ReporteDiario> buscarPorEmpleado(int idEmpleado) {
        return repositorio.buscarPorEmpleado(idEmpleado);
    }

    @Override
    public List<ReporteDiario> buscarPorEmpleadoYFecha(int idEmpleado, LocalDate fecha) {
        return repositorio.buscarPorEmpleadoYFecha(idEmpleado, fecha);
    }

    @Override
    public List<ReporteDiario> listarConTardanza() {
        return repositorio.listarConTardanza();
    }

    @Override
    public List<ReporteDiario> listarMarcacionesIncompletas() {
        return repositorio.listarMarcacionesIncompletas();
    }
}