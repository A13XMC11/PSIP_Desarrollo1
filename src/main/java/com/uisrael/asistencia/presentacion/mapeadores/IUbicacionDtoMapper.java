package com.uisrael.asistencia.presentacion.mapeadores;

import com.uisrael.asistencia.dominio.entidades.Ubicacion;
import com.uisrael.asistencia.presentacion.dto.request.UbicacionRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.UbicacionResponseDto;

public interface IUbicacionDtoMapper {
	Ubicacion toDomain(UbicacionRequestDto dto);

	UbicacionResponseDto toResponseDto(Ubicacion ubicacionPojo);
}
