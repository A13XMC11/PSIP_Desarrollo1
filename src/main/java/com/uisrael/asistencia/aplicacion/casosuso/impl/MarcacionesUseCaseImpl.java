package com.uisrael.asistencia.aplicacion.casosuso.impl;

import java.time.LocalDate;
import java.util.List;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IMarcacionesUsaCase;
import com.uisrael.asistencia.dominio.entidades.Marcaciones;
import com.uisrael.asistencia.dominio.repositorio.IMarcacionesRepositorio;

public class MarcacionesUseCaseImpl implements IMarcacionesUsaCase {

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
		return repositorio.buscarPorId(idMarcaciones)
				.orElseThrow(() -> new RuntimeException("No se encontraron marcaciones"));
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

	@Override
	public List<Marcaciones> buscarPorEmpleado(int idEmpleado) {
		return repositorio.buscarPorEmpleado(idEmpleado);
	}

	@Override
	public List<Marcaciones> buscarPorEmpleadoYFecha(int idEmpleado, LocalDate fecha) {
		return repositorio.buscarPorEmpleadoYFecha(idEmpleado, fecha);
	}

	@Override
	public List<Marcaciones> buscarPorTipo(String tipo) {
		return repositorio.buscarPorTipo(tipo);
	}

	@Override
	public List<Marcaciones> listarMarcacionesValidas() {
		return repositorio.listarMarcacionesValidas();
	}

	@Override
	public List<Marcaciones> listarMarcacionesCorrectas() {
		return repositorio.listarMarcacionesCorrectas();
	}

	@Override
	public List<Marcaciones> buscarPorUbicacion(int idUbicacion) {
		return repositorio.buscarPorUbicacion(idUbicacion);
	}

}
