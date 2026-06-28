package com.uisrael.asistencia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.Ubicacion;
import com.uisrael.asistencia.dominio.repositorio.IUbicacionRepositorio;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.UbicacionEntity;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IUbicacionJpaMapper;
import com.uisrael.asistencia.infraestructura.repositorios.IUbicacionJpaRepositorio;

public class UbicacionRepositorioImpl implements IUbicacionRepositorio {

	private final IUbicacionJpaRepositorio jpaRepositorio;

	private final IUbicacionJpaMapper entityMapper;

	public UbicacionRepositorioImpl(IUbicacionJpaRepositorio jpaRepositorio, IUbicacionJpaMapper entityMapper) {

		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Ubicacion guardar(Ubicacion nuevaUbicacion) {
		UbicacionEntity entity = entityMapper.toEntity(nuevaUbicacion);
		UbicacionEntity guardado = jpaRepositorio.save(entity);

		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Ubicacion> buscarPorId(int idUbicacion) {

		return jpaRepositorio.findById(idUbicacion).map(entityMapper::toDomain);
	}

	@Override
	public List<Ubicacion> listarTodos() {

		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idUbicacion) {
		jpaRepositorio.deleteById(idUbicacion);

	}

}
