package com.uisrael.asistencia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.CodigosTemporales;
import com.uisrael.asistencia.dominio.repositorio.ICodigosTemporalesRepositorio;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.CodigosTemporalesEntity;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.ICodigosTemporalesJpaMapper;
import com.uisrael.asistencia.infraestructura.repositorios.ICodigosTemporalesJpaRepositorio;

public class CodigosTempralesRepositorioImpl implements ICodigosTemporalesRepositorio{
	
	private final ICodigosTemporalesJpaRepositorio jpaRepositorio;
	private final ICodigosTemporalesJpaMapper entityMapper;
	
	public CodigosTempralesRepositorioImpl(ICodigosTemporalesJpaRepositorio jpaRepositorio,
			ICodigosTemporalesJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public CodigosTemporales guardar(CodigosTemporales nuevoCodigo) {
		CodigosTemporalesEntity entity = entityMapper.toEntity(nuevoCodigo);
		CodigosTemporalesEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<CodigosTemporales> buscarPorId(int idCodigosTemporales) {
		return jpaRepositorio.findById(idCodigosTemporales).map(entityMapper::toDomain);
	}

	@Override
	public List<CodigosTemporales> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idCodigosTemporales) {
		jpaRepositorio.deleteById(idCodigosTemporales);		
	}
	
	
}
