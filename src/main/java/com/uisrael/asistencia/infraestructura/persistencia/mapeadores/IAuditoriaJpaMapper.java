package com.uisrael.asistencia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.asistencia.dominio.entidades.Auditoria;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.AuditoriaEntity;

@Mapper(componentModel = "spring")
public interface IAuditoriaJpaMapper {

	Auditoria toDomain(AuditoriaEntity entity);
	
	AuditoriaEntity toEntity(Auditoria auditoriaPojo);
}
