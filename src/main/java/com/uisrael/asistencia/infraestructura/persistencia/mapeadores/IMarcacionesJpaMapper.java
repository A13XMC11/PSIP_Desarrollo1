package com.uisrael.asistencia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.asistencia.dominio.entidades.Marcaciones;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.MarcacionesEntity;

@Mapper(componentModel = "spring")
public interface IMarcacionesJpaMapper {

	Marcaciones toDomain(MarcacionesEntity entity);

	MarcacionesEntity toEntity(Marcaciones marcacionesPojo);

}
