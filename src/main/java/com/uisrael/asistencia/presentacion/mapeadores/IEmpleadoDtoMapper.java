package com.uisrael.asistencia.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.asistencia.dominio.entidades.Empleado;
import com.uisrael.asistencia.presentacion.dto.request.EmpleadoRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.EmpleadoResponseDto;

@Mapper(componentModel = "spring")
public interface IEmpleadoDtoMapper {

	Empleado toDomain(EmpleadoRequestDto dto);

	EmpleadoResponseDto toResponseDto(Empleado empleadoPojo);
}
