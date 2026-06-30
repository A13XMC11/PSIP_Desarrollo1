package com.uisrael.asistencia.dominio.repositorio;

import java.util.List;
import java.util.Optional;
import com.uisrael.asistencia.dominio.entidades.ReporteDiario;

public interface IReporteDiarioRepositorio {

	ReporteDiario guardar(ReporteDiario nuevoReporteDiario);

	Optional<ReporteDiario> buscarPorId(int idReporteDiario);

	List<ReporteDiario> listarTodos();

	void eliminar(int idReporteDiario);
}
