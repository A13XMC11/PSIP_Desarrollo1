package com.uisrael.asistencia.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.asistencia.dominio.entidades.CodigosTemporales;
import com.uisrael.asistencia.presentacion.dto.request.CodigosTemporalesRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.CodigosTemporalesResponseDto;

@Mapper (componentModel = "spring")
public interface ICodigosTemporalesDtoMapper {
	
	CodigosTemporales toDomain(CodigosTemporalesRequestDto dto);

	CodigosTemporalesResponseDto toResponseDto(CodigosTemporales CodigosTemporalesPojo);
}
