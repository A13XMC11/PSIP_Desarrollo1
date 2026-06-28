package com.uisrael.asistencia.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IMarcacionesUsaCase;
import com.uisrael.asistencia.dominio.entidades.Marcaciones;
import com.uisrael.asistencia.dominio.repositorio.IMarcacionesRepositorio;

public class MarcacionesUseCaseImpl implements IMarcacionesUsaCase{
	
	private final IMarcacionesRepositorio repositorio;

	public MarcacionesUseCaseImpl(IMarcacionesRepositorio repositorio) {
		
		this.repositorio = repositorio;
	}

	@Override
	public Marcaciones guardar(Marcaciones nuevaMarcacion) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevaMarcacion);
	}

	@Override
	public Marcaciones buscarPorId(int idMarcaciones) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idMarcaciones).orElseThrow(() -> new RuntimeException("No se encontraron marcaciones"));
	}

	@Override
	public List<Marcaciones> listarTodos() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idMarcaciones) {
		repositorio.eliminar(idMarcaciones);
		
	}
	
	

}
