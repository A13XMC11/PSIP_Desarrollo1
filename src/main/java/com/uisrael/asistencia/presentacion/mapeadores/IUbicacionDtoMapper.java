package com.uisrael.asistencia.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.asistencia.dominio.entidades.Ubicacion;

import com.uisrael.asistencia.presentacion.dto.request.UbicacionRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.UbicacionResponseDto;

@Mapper(componentModel = "spring")
public interface IUbicacionDtoMapper {
	Ubicacion toDomain(UbicacionRequestDto dto);

	UbicacionResponseDto toResponseDto(Ubicacion ubicacionPojo);
}
