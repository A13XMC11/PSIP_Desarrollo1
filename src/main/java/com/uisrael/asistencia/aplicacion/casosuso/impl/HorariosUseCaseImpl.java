package com.uisrael.asistencia.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IHorariosUseCase;
import com.uisrael.asistencia.dominio.entidades.Horarios;
import com.uisrael.asistencia.dominio.repositorio.IHorariosRepositorio;

public class HorariosUseCaseImpl implements IHorariosUseCase{
	
	private final IHorariosRepositorio repositorio;

	public HorariosUseCaseImpl(IHorariosRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Horarios guardar(Horarios nuevoHorario) {
		return repositorio.guardar(nuevoHorario);
	}

	@Override
	public Horarios buscarPorId(int idHorarios) {
		return repositorio.buscarPorId(idHorarios)
				.orElseThrow(() -> new RuntimeException("No se encontro el horario"));
	}

	@Override
	public List<Horarios> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idHorarios) {
		repositorio.eliminar(idHorarios);
	}
	
}
