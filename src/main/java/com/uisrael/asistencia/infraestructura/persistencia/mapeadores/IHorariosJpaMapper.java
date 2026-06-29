package com.uisrael.asistencia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.asistencia.dominio.entidades.Horarios;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.HorariosEntity;

@Mapper(componentModel = "spring")
public interface IHorariosJpaMapper {

	Horarios toDomain(HorariosEntity entity);

	HorariosEntity toEntity(Horarios horariosPojo);
}
