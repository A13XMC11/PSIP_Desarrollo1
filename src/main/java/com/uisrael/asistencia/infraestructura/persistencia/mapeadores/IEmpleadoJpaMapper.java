package com.uisrael.asistencia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.asistencia.dominio.entidades.Empleado;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.EmpleadoEntity;

@Mapper(componentModel = "spring")
public interface IEmpleadoJpaMapper {
	
	Empleado toDomain(EmpleadoEntity entity);
	
	EmpleadoEntity toEntity(Empleado empleadoPojo);

}
