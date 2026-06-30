package com.uisrael.asistencia.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IReporteDiarioUseCase;
import com.uisrael.asistencia.dominio.entidades.ReporteDiario;
import com.uisrael.asistencia.dominio.repositorio.IReporteDiarioRepositorio;

public class ReporteDiarioUseCaseImpl implements IReporteDiarioUseCase{

	private final IReporteDiarioRepositorio repositorio;
	

	public ReporteDiarioUseCaseImpl(IReporteDiarioRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public ReporteDiario guardar(ReporteDiario nuevoReporteDiario) {
		return repositorio.guardar(nuevoReporteDiario);
	}

	@Override
	public ReporteDiario buscarPorId(int idReporteDiario) {
		return repositorio.buscarPorId(idReporteDiario)
				.orElseThrow(() -> new RuntimeException("No se encontro Reporte Diario"));
	}

	@Override
	public List<ReporteDiario> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idReporteDiario) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idReporteDiario);
	}

}
