package com.uisrael.asistencia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.asistencia.dominio.entidades.CodigosTemporales;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.CodigosTemporalesEntity;

@Mapper(componentModel = "spring")
public interface ICodigosTemporalesJpaMapper {

	CodigosTemporales toDomain(CodigosTemporalesEntity entity);

	CodigosTemporalesEntity toEntity(CodigosTemporales codigosTemporalesPojo);
}
