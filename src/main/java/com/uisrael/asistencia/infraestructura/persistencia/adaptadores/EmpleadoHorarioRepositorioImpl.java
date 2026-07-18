package com.uisrael.asistencia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.EmpleadoHorario;
import com.uisrael.asistencia.dominio.repositorio.IEmpleadoHorarioRepositorio;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.EmpleadoHorarioEntity;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IEmpleadoHorarioJpaMapper;
import com.uisrael.asistencia.infraestructura.repositorios.IEmpleadoHorarioJpaRepositorio;

public class EmpleadoHorarioRepositorioImpl implements IEmpleadoHorarioRepositorio{

	private final IEmpleadoHorarioJpaRepositorio jpaRepositorio;
	private final IEmpleadoHorarioJpaMapper entityMapper;
	
	public EmpleadoHorarioRepositorioImpl(IEmpleadoHorarioJpaRepositorio jpaRepositorio,
			IEmpleadoHorarioJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public EmpleadoHorario guardar(EmpleadoHorario nuevoEmpleadoHorario) {
		EmpleadoHorarioEntity entity = entityMapper.toEntity(nuevoEmpleadoHorario);
		EmpleadoHorarioEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);	}

	@Override
	public Optional<EmpleadoHorario> buscarPorId(int idEmpleadoHorario) {
		return jpaRepositorio.findById(idEmpleadoHorario).map(entityMapper::toDomain);
	}

	@Override
	public List<EmpleadoHorario> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idEmpleadoHorario) {
		jpaRepositorio.deleteById(idEmpleadoHorario);
		
	}

	@Override
	public List<EmpleadoHorario> buscarHorariosActivosPorEmpleado(int idEmpleado) {
        return jpaRepositorio.buscarHorariosActivosPorEmpleado(idEmpleado).stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public List<EmpleadoHorario> buscarPorHorario(int idHorario) {
        return jpaRepositorio.buscarPorHorario(idHorario).stream().map(entityMapper::toDomain).toList();
	}
	
	
}
