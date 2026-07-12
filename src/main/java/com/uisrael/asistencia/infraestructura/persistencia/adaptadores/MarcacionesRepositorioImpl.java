package com.uisrael.asistencia.infraestructura.persistencia.adaptadores;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.Marcaciones;
import com.uisrael.asistencia.dominio.repositorio.IMarcacionesRepositorio;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.MarcacionesEntity;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IMarcacionesJpaMapper;
import com.uisrael.asistencia.infraestructura.repositorios.IMarcacionesJpaRepositorio;

public class MarcacionesRepositorioImpl implements IMarcacionesRepositorio {

	private final IMarcacionesJpaRepositorio jpaRerpositorio;

	private final IMarcacionesJpaMapper entityMapper;

	public MarcacionesRepositorioImpl(IMarcacionesJpaRepositorio jpaRerpositorio, IMarcacionesJpaMapper entityMapper) {
		super();
		this.jpaRerpositorio = jpaRerpositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Marcaciones guardar(Marcaciones nuevaMarcacion) {
		MarcacionesEntity entity = entityMapper.toEntity(nuevaMarcacion);
		MarcacionesEntity guardado = jpaRerpositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Marcaciones> buscarPorId(int idMarcaciones) {

		return jpaRerpositorio.findById(idMarcaciones).map(entityMapper::toDomain);
	}

	@Override
	public List<Marcaciones> listarTodos() {

		return jpaRerpositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idMarcaciones) {
		jpaRerpositorio.deleteById(idMarcaciones);

	}

	@Override
	public List<Marcaciones> buscarPorEmpleado(int idEmpleado) {
		return jpaRerpositorio.buscarPorEmpleado(idEmpleado).stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public List<Marcaciones> buscarPorEmpleadoYFecha(int idEmpleado, LocalDate fecha) {
		return jpaRerpositorio.buscarPorEmpleadoYFecha(idEmpleado, fecha).stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public List<Marcaciones> buscarPorTipo(String tipo) {
		return jpaRerpositorio.buscarPorTipo(tipo).stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public List<Marcaciones> listarMarcacionesValidas() {
		return jpaRerpositorio.listarMarcacionesValidas().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public List<Marcaciones> listarMarcacionesCorrectas() {
		return jpaRerpositorio.listarMarcacionesCorrectas().stream().map(entityMapper::toDomain).toList();
	}

}
