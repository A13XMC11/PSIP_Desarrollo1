package com.uisrael.asistencia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.asistencia.dominio.entidades.ReporteDiario;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.ReporteDiarioEntity;

@Mapper(componentModel = "spring")
public interface IReporteDiarioJpaMapper {

	ReporteDiario toDomain(ReporteDiarioEntity entity);
	
	ReporteDiarioEntity toEntity(ReporteDiario reporteDiarioPojo);
}
