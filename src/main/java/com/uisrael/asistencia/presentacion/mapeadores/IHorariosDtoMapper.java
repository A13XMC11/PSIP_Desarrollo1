package com.uisrael.asistencia.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.asistencia.dominio.entidades.Horarios;
import com.uisrael.asistencia.presentacion.dto.request.HorariosRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.HorariosResponseDto;

@Mapper (componentModel = "spring")
public interface IHorariosDtoMapper {
	
	Horarios toDomain(HorariosRequestDto dto);

	HorariosResponseDto toResponseDto(Horarios HorariosPojo);
}
