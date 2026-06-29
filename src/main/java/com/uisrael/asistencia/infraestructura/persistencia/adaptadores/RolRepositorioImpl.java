package com.uisrael.asistencia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.Rol;
import com.uisrael.asistencia.dominio.repositorio.IRolRepositorio;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.RolEntity;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IRolJpaMapper;
import com.uisrael.asistencia.infraestructura.repositorios.IRolJpaRepositorio;

public class RolRepositorioImpl implements IRolRepositorio {

	private final IRolJpaRepositorio jpaRepositorio;
	private final IRolJpaMapper entityMapper;

	public RolRepositorioImpl(IRolJpaRepositorio jpaRepositorio, IRolJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Rol guardar(Rol nuevoRol) {
		RolEntity entity = entityMapper.toEntity(nuevoRol);
		RolEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Rol> buscarPorId(int idRol) {
		return jpaRepositorio.findById(idRol).map(entityMapper::toDomain);
	}

	@Override
	public List<Rol> listarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idRol) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idRol);
	}

}
