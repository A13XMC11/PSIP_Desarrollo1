package com.uisrael.asistencia.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.asistencia.dominio.entidades.EmpleadoHorario;
import com.uisrael.asistencia.presentacion.dto.request.EmpleadoHorarioRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.EmpleadoHorarioResponseDto;

@Mapper (componentModel = "spring")
public interface IEmpleadoHorarioDtoMapper {
	
	EmpleadoHorario toDomain(EmpleadoHorarioRequestDto dto);

	EmpleadoHorarioResponseDto toResponseDto(EmpleadoHorario EmpleadoHorarioPojo);
}
