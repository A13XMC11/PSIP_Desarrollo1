package com.uisrael.asistencia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.Auditoria;
import com.uisrael.asistencia.dominio.repositorio.IAuditoriaRepositorio;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IAuditoriaJpaMapper;
import com.uisrael.asistencia.infraestructura.repositorios.IAuditoriaJpaRepositorio;

public class AuditoriaRepositorioImpl implements IAuditoriaRepositorio {

	private final IAuditoriaJpaRepositorio jpaRepositorio;
	private final IAuditoriaJpaMapper entityMapper;

	public AuditoriaRepositorioImpl(IAuditoriaJpaRepositorio jpaRepositorio, IAuditoriaJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Auditoria guardar(Auditoria nuevaAuditoria) {
		return entityMapper.toDomain(jpaRepositorio.save(entityMapper.toEntity(nuevaAuditoria)));
	}

	@Override
	public Optional<Auditoria> buscarPorId(Long idAuditoria) {
		return jpaRepositorio.findById(idAuditoria).map(entityMapper::toDomain);
	}

	@Override
	public List<Auditoria> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(Long idAuditoria) {
		jpaRepositorio.deleteById(idAuditoria);
	}

	@Override
	public List<Auditoria> buscarPorEmpleado(int idEmpleado) {
		return jpaRepositorio.buscarPorEmpleado(idEmpleado).stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public List<Auditoria> buscarPorTabla(String tabla) {
		return jpaRepositorio.buscarPorTabla(tabla).stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public List<Auditoria> buscarPorIp(String ip) {
		return jpaRepositorio.buscarPorIp(ip).stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public List<Auditoria> buscarPorAccion(String accion) {
		return jpaRepositorio.buscarPorAccion(accion).stream().map(entityMapper::toDomain).toList();
	}

}