package com.uisrael.asistencia.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.asistencia.dominio.entidades.Marcaciones;
import com.uisrael.asistencia.presentacion.dto.request.MarcacionesRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.MarcacionesResponseDto;

@Mapper(componentModel = "spring")
public interface IMarcacionesDtoMapper {
	
	Marcaciones toDomain(MarcacionesRequestDto dto);

	MarcacionesResponseDto toResponseDto(Marcaciones marcacionesPojo);
}
