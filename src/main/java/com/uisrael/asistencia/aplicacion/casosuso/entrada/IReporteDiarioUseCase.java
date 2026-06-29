package com.uisrael.asistencia.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.asistencia.dominio.entidades.ReporteDiario;

public interface IReporteDiarioUseCase {

	ReporteDiario guardar(ReporteDiario nuevoReporteDiario);

	ReporteDiario buscarPorId(int idReporteDiario);

	List<ReporteDiario> listarTodos();

	void eliminar(int idReporteDiario);
}
