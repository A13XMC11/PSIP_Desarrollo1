package com.uisrael.asistencia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.Horarios;
import com.uisrael.asistencia.dominio.repositorio.IHorariosRepositorio;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.HorariosEntity;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IHorariosJpaMapper;
import com.uisrael.asistencia.infraestructura.repositorios.IHorariosJpaRepositorio;

public class HorariosRepositorioImpl implements IHorariosRepositorio{
	
	private final IHorariosJpaRepositorio jpaRepositorio;
	private final IHorariosJpaMapper entityMapper;
	
	public HorariosRepositorioImpl(IHorariosJpaRepositorio jpaRepositorio, IHorariosJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Horarios guardar(Horarios nuevoHorario) {
		HorariosEntity entity = entityMapper.toEntity(nuevoHorario);
		HorariosEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Horarios> buscarPorId(int idHorarios) {
		return jpaRepositorio.findById(idHorarios).map(entityMapper::toDomain);
	}

	@Override
	public List<Horarios> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idHorarios) {
		jpaRepositorio.deleteById(idHorarios);		
	}

	
	
	
}
