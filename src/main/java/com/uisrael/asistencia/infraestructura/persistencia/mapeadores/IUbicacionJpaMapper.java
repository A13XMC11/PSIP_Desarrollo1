package com.uisrael.asistencia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.asistencia.dominio.entidades.Ubicacion;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.UbicacionEntity;

@Mapper(componentModel = "Spring")
public interface IUbicacionJpaMapper {

	Ubicacion toDomain(UbicacionEntity entity);

	UbicacionEntity toEntity(Ubicacion ubicacionPojo);

}
