package com.uisrael.asistencia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.asistencia.dominio.entidades.Marcaciones;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.MarcacionesEntity;

@Mapper(componentModel = "spring")
public interface IMarcacionesJpaMapper {

	@Mapping(target = "fkEmpleadoEntity", ignore = true)
	@Mapping(target = "fkCodigoEntity", ignore = true)
	@Mapping(target = "fkUbicacionEntity", ignore = true)
	Marcaciones toDomain(MarcacionesEntity entity);

	@Mapping(target = "idEmpleado", source = "fkEmpleadoEntity.idEmpleado")
	@Mapping(target = "idCodigo", source = "fkCodigoEntity.idCodigo")
	@Mapping(target = "idUbicacion", source = "fkUbicacionEntity.idUbicacion")
	MarcacionesEntity toEntity(Marcaciones marcacionesPojo);

}
