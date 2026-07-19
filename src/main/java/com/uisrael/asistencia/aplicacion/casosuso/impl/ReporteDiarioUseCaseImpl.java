package com.uisrael.asistencia.aplicacion.casosuso.impl;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IReporteDiarioUseCase;
import com.uisrael.asistencia.dominio.entidades.EmpleadoHorario;
import com.uisrael.asistencia.dominio.entidades.Horarios;
import com.uisrael.asistencia.dominio.entidades.Marcaciones;
import com.uisrael.asistencia.dominio.entidades.ReporteDiario;
import com.uisrael.asistencia.dominio.repositorio.IEmpleadoHorarioRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IHorariosRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IMarcacionesRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IReporteDiarioRepositorio;

public class ReporteDiarioUseCaseImpl implements IReporteDiarioUseCase {

	private final IReporteDiarioRepositorio repositorio;
	private final IMarcacionesRepositorio marcacionesRepositorio;
	private final IEmpleadoHorarioRepositorio empleadoHorarioRepositorio;
	private final IHorariosRepositorio horariosRepositorio;

	public ReporteDiarioUseCaseImpl(IReporteDiarioRepositorio repositorio,
			IMarcacionesRepositorio marcacionesRepositorio, IEmpleadoHorarioRepositorio empleadoHorarioRepositorio,
			IHorariosRepositorio horariosRepositorio) {
		this.repositorio = repositorio;
		this.marcacionesRepositorio = marcacionesRepositorio;
		this.empleadoHorarioRepositorio = empleadoHorarioRepositorio;
		this.horariosRepositorio = horariosRepositorio;
	}

	@Override
	public ReporteDiario guardar(ReporteDiario nuevoReporteDiario) {
		return repositorio.guardar(nuevoReporteDiario);
	}

	@Override
	public ReporteDiario buscarPorId(int idReporteDiario) {
		return repositorio.buscarPorId(idReporteDiario)
				.orElseThrow(() -> new RuntimeException("No se encontro ReporteDiario"));
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

	@Override
	public void generarOActualizar(int idEmpleado, LocalDate fecha) {
		List<Marcaciones> marcacionesDelDia = marcacionesRepositorio.buscarPorEmpleadoYFecha(idEmpleado, fecha);

		Marcaciones entrada = null;
		Marcaciones salida = null;
		for (Marcaciones m : marcacionesDelDia) {
			if (m.getTipo().equals("ENTRADA") && entrada == null) {
				entrada = m;
			}
			if (m.getTipo().equals("SALIDA")) {
				salida = m;
			}
		}

		ReporteDiario reporte = new ReporteDiario();
		reporte.setIdEmpleado(idEmpleado);
		reporte.setFechaReporte(fecha);
		reporte.setHoraEntrada(entrada != null ? entrada.getHoraMarcacion() : null);
		reporte.setHoraSalida(salida != null ? salida.getHoraMarcacion() : null);
		reporte.setMarcacionIncompleta(entrada == null || salida == null);

		List<EmpleadoHorario> asignaciones = empleadoHorarioRepositorio.buscarHorariosActivosPorEmpleado(idEmpleado);
		if (entrada != null && !asignaciones.isEmpty()) {
			Horarios horario = horariosRepositorio.buscarPorId(asignaciones.get(0).getIdHorario())
					.orElseThrow(() -> new RuntimeException("Horario no encontrado"));
			if (entrada.getHoraMarcacion().isAfter(horario.getHoraEntrada())) {
				reporte.setTardanzaReporte(true);
				long minutos = Duration.between(horario.getHoraEntrada(), entrada.getHoraMarcacion()).toMinutes();
				reporte.setMinutosTardanza((int) minutos);
			}
		}

		repositorio.guardar(reporte);
	}
}