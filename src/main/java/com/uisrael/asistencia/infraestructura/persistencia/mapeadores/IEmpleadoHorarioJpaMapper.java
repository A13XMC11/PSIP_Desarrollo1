package com.uisrael.asistencia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.asistencia.dominio.entidades.EmpleadoHorario;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.EmpleadoHorarioEntity;

@Mapper(componentModel = "spring")
public interface IEmpleadoHorarioJpaMapper {

	EmpleadoHorario toDomain(EmpleadoHorarioEntity entity);

	EmpleadoHorarioEntity toEntity(EmpleadoHorario empleadoHorarioPojo);
}
