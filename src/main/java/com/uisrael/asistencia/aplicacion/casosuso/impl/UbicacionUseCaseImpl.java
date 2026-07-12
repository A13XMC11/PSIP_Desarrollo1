package com.uisrael.asistencia.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IUbicacionUseCase;
import com.uisrael.asistencia.dominio.entidades.Ubicacion;
import com.uisrael.asistencia.dominio.repositorio.IUbicacionRepositorio;

public class UbicacionUseCaseImpl implements IUbicacionUseCase {
	private final IUbicacionRepositorio repositorio;

	public UbicacionUseCaseImpl(IUbicacionRepositorio repositorio) {

		this.repositorio = repositorio;
	}

	@Override
	public Ubicacion guardar(Ubicacion nuevaUbicacion) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevaUbicacion);
	}

	@Override
	public Ubicacion buscarPorId(int idUbicacion) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idUbicacion).orElseThrow(() -> new RuntimeException("No se encontro ubicacion"));
	}

	@Override
	public List<Ubicacion> listarTodos() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idUbicacion) {
		repositorio.eliminar(idUbicacion);

	}
	
	@Override
    public List<Ubicacion> listarUbicacionesActivas() {
        return repositorio.listarUbicacionesActivas();
    }

    @Override
    public List<Ubicacion> buscarPorNombre(String nombre) {
        return repositorio.findByNombreUbicacion(nombre);
    }

}
