package com.uisrael.asistencia.presentacion.mapeadores;

import com.uisrael.asistencia.dominio.entidades.Marcaciones;
import com.uisrael.asistencia.presentacion.dto.request.MarcacionesRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.MarcacionesResponseDto;

public interface IMarcacionesDtoMapper {
	
	Marcaciones toDomain(MarcacionesRequestDto dto);

	MarcacionesResponseDto toRespnseDto(Marcaciones marcacionesDto);
}
