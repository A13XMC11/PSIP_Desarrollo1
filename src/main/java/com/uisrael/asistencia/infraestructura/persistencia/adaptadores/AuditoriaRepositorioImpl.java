package com.uisrael.asistencia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.Auditoria;
import com.uisrael.asistencia.dominio.repositorio.IAuditoriaRepositorio;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.AuditoriaEntity;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IAuditoriaJpaMapper;
import com.uisrael.asistencia.infraestructura.repositorios.IAuditoriaJpaRepositorio;

public class AuditoriaRepositorioImpl implements IAuditoriaRepositorio {

	private final IAuditoriaJpaRepositorio jpaRepositorio;
	private final IAuditoriaJpaMapper entityMapper;

	public AuditoriaRepositorioImpl(IAuditoriaJpaRepositorio jpaRepositorio, IAuditoriaJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Auditoria guardar(Auditoria nuevaAuditoria) {
		AuditoriaEntity entity = entityMapper.toEntity(nuevaAuditoria);
		AuditoriaEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
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
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idAuditoria);
	}

}
