package com.uisrael.asistencia.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.asistencia.dominio.entidades.Marcaciones;
import com.uisrael.asistencia.presentacion.dto.request.MarcacionesRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.MarcacionesResponseDto;

@Mapper(componentModel = "spring")
public interface IMarcacionesDtoMapper {
	
	Marcaciones toDomain(MarcacionesRequestDto dto);

	@Mapping(target = "idEmpleado", source = "fkEmpleadoEntity.idEmpleado")
	@Mapping(target = "idCodigo", source = "fkCodigoEntity.idCodigo")
	@Mapping(target = "idUbicacion", source = "fkUbicacionEntity.idUbicacion")
	MarcacionesResponseDto toResponseDto(Marcaciones marcacionesPojo);
}
