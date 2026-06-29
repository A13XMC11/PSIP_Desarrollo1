package com.uisrael.asistencia.infraestructura.persistencia.mapeadores;


import org.mapstruct.Mapper;

import com.uisrael.asistencia.dominio.entidades.Rol;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.RolEntity;

@Mapper(componentModel = "spring")
public interface IRolJpaMapper {

	Rol toDomain(RolEntity entity);
	
	RolEntity toEntity(Rol RolPojo);
}
