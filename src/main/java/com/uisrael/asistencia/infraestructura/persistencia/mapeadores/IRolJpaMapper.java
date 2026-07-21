package com.uisrael.asistencia.infraestructura.persistencia.mapeadores;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.asistencia.dominio.entidades.Rol;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.RolEntity;

@Mapper(componentModel = "spring")
public interface IRolJpaMapper {
	@Mapping(target = "nombreRol", source = "nombre")
	@Mapping(target = "descripcionRol", source = "descripcion")
	Rol toDomain(RolEntity entity);
	
	@Mapping(target = "nombre", source = "nombreRol")
	@Mapping(target = "descripcion", source = "descripcionRol")
	RolEntity toEntity(Rol RolPojo);
}
