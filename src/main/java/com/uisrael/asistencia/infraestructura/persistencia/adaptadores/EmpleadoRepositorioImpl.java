package com.uisrael.asistencia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.Empleado;
import com.uisrael.asistencia.dominio.repositorio.IEmpleadoRepositorio;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.EmpleadoEntity;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IEmpleadoJpaMapper;
import com.uisrael.asistencia.infraestructura.repositorios.IEmpleadoJpaRepositorio;

public class EmpleadoRepositorioImpl implements IEmpleadoRepositorio {
	private final IEmpleadoJpaRepositorio jpaRepositorio;
	private final IEmpleadoJpaMapper entityMapper;

	public EmpleadoRepositorioImpl(IEmpleadoJpaRepositorio jpaRepositorio, IEmpleadoJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Empleado guardar(Empleado nuevoEmpleado) {
		EmpleadoEntity entity = entityMapper.toEntity(nuevoEmpleado);
		EmpleadoEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Empleado> buscarPorId(int idEmpleado) {

		return jpaRepositorio.findById(idEmpleado).map(entityMapper::toDomain);
	}

	@Override
	public List<Empleado> listarTodos() {

		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idEmpleado) {
		jpaRepositorio.deleteById(idEmpleado);

	}

	@Override
	public List<Empleado> findByCorreoEmpleado(String correo) {
		return jpaRepositorio.findByCorreoEmpleado(correo).stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public List<Empleado> listarEmpleadosActivos() {
		return jpaRepositorio.listarEmpleadosActivos().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public List<Empleado> buscarPorRol(int idRol) {
		return jpaRepositorio.buscarPorRol(idRol).stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public List<Empleado> buscarPorNombre(String nombre) {
		return jpaRepositorio.buscarPorNombre(nombre).stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public List<Empleado> buscarPorApellido(String apellido) {
		return jpaRepositorio.buscarPorApellido(apellido).stream().map(entityMapper::toDomain).toList();
	}

}
