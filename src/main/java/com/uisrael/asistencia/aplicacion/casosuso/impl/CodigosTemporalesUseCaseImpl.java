package com.uisrael.asistencia.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.ICodigosTemporalesUseCase;
import com.uisrael.asistencia.dominio.entidades.CodigosTemporales;
import com.uisrael.asistencia.dominio.repositorio.ICodigosTemporalesRepositorio;

public class CodigosTemporalesUseCaseImpl implements ICodigosTemporalesUseCase{
	
	private final ICodigosTemporalesRepositorio repositorio;

	public CodigosTemporalesUseCaseImpl(ICodigosTemporalesRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public CodigosTemporales guardar(CodigosTemporales nuevoCodigo) {
		return repositorio.guardar(nuevoCodigo);
	}

	@Override
	public CodigosTemporales buscarPorId(int idCodigoTemporal) {
		return repositorio.buscarPorId(idCodigoTemporal)
				.orElseThrow(() -> new RuntimeException("No se encontro el codigo temporal"));
	}

	@Override
	public List<CodigosTemporales> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idCodigosTemporales) {
		repositorio.eliminar(idCodigosTemporales);
	}
	
	
}
