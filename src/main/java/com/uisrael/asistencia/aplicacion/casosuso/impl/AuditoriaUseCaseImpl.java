package com.uisrael.asistencia.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IAuditoriaUseCase;
import com.uisrael.asistencia.dominio.entidades.Auditoria;
import com.uisrael.asistencia.dominio.repositorio.IAuditoriaRepositorio;


public class AuditoriaUseCaseImpl implements IAuditoriaUseCase{
	
	private final IAuditoriaRepositorio repositorio;
	

	public AuditoriaUseCaseImpl(IAuditoriaRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Auditoria guardar(Auditoria nuevaAuditoria) {
		return repositorio.guardar(nuevaAuditoria);
	}

	@Override
	public Auditoria buscarPorId(int idAuditoria) {
		return repositorio.buscarPorId(idAuditoria)
				.orElseThrow(() -> new RuntimeException("No se encontro Auditoria"));
	}

	@Override
	public List<Auditoria> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idAuditoria) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idAuditoria);
	}

}
