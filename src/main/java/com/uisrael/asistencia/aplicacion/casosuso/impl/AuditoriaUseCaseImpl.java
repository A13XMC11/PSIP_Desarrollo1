package com.uisrael.asistencia.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IAuditoriaUseCase;
import com.uisrael.asistencia.dominio.entidades.Auditoria;
import com.uisrael.asistencia.dominio.repositorio.IAuditoriaRepositorio;

public class AuditoriaUseCaseImpl implements IAuditoriaUseCase {

	private final IAuditoriaRepositorio repositorio;

	public AuditoriaUseCaseImpl(IAuditoriaRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Auditoria guardar(Auditoria nuevaAuditoria) {
		return repositorio.guardar(nuevaAuditoria);
	}

	@Override
	public Auditoria buscarPorId(Long idAuditoria) {
		return repositorio.buscarPorId(idAuditoria).orElseThrow(() -> new RuntimeException("No se encontro Auditoria"));
	}

	@Override
	public List<Auditoria> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(Long idAuditoria) {
		repositorio.eliminar(idAuditoria);
	}

	@Override
	public List<Auditoria> buscarPorEmpleado(int idEmpleado) {
		return repositorio.buscarPorEmpleado(idEmpleado);
	}

	@Override
	public List<Auditoria> buscarPorTabla(String tabla) {
		return repositorio.buscarPorTabla(tabla);
	}

	@Override
	public List<Auditoria> buscarPorIp(String ip) {
		return repositorio.buscarPorIp(ip);
	}

	@Override
	public List<Auditoria> buscarPorAccion(String accion) {
		return repositorio.buscarPorAccion(accion);
	}

}