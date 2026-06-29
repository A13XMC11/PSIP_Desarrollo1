package com.uisrael.asistencia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.ReporteDiario;
import com.uisrael.asistencia.dominio.repositorio.IReporteDiarioRepositorio;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.ReporteDiarioEntity;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IReporteDiarioJpaMapper;
import com.uisrael.asistencia.infraestructura.repositorios.IReporteDiarioJpaRepositorio;

public class ReporteDiarioRepositorioImpl implements IReporteDiarioRepositorio {

	private final IReporteDiarioJpaRepositorio jpaRepositorio;
	private final IReporteDiarioJpaMapper entityMapper;

	public ReporteDiarioRepositorioImpl(IReporteDiarioJpaRepositorio jpaRepositorio,
			IReporteDiarioJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public ReporteDiario guardar(ReporteDiario nuevoReporteDiario) {
		ReporteDiarioEntity entity = entityMapper.toEntity(nuevoReporteDiario);
		ReporteDiarioEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<ReporteDiario> buscarPorId(int idReporteDiario) {
		return jpaRepositorio.findById(idReporteDiario).map(entityMapper::toDomain);
	}

	@Override
	public List<ReporteDiario> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idReporteDiario) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idReporteDiario);
	}

}
