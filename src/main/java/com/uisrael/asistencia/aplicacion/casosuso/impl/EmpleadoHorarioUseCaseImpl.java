package com.uisrael.asistencia.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IEmpleadoHorarioUseCase;
import com.uisrael.asistencia.dominio.entidades.EmpleadoHorario;
import com.uisrael.asistencia.dominio.repositorio.IEmpleadoHorarioRepositorio;

public class EmpleadoHorarioUseCaseImpl implements IEmpleadoHorarioUseCase{
	
	private final IEmpleadoHorarioRepositorio repositorio;

	public EmpleadoHorarioUseCaseImpl(IEmpleadoHorarioRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public EmpleadoHorario guardar(EmpleadoHorario nuevoEmpleadoHorario) {
		return repositorio.guardar(nuevoEmpleadoHorario);
	}

	@Override
	public EmpleadoHorario buscarPorId(int idEmpleadoHorario) {
		return repositorio.buscarPorId(idEmpleadoHorario)
				.orElseThrow(() -> new RuntimeException("No se encontro el empleadoHorario"));
	}

	@Override
	public List<EmpleadoHorario> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idEmpleadoHorario) {
		repositorio.eliminar(idEmpleadoHorario);
	}

	@Override
	public List<EmpleadoHorario> buscarHorariosActivosPorEmpleado(int idEmpleado) {
        return repositorio.buscarHorariosActivosPorEmpleado(idEmpleado);
	}

	@Override
	public List<EmpleadoHorario> buscarPorHorario(int idHorario) {
        return repositorio.buscarPorHorario(idHorario);
	}
	
	
}
