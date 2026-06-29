package com.uisrael.asistencia.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.asistencia.dominio.entidades.Rol;

import com.uisrael.asistencia.presentacion.dto.request.RolRequestDto;

import com.uisrael.asistencia.presentacion.dto.response.RolResponseDto;

@Mapper(componentModel = "spring")
public interface IRolDtoMapper {

	Rol toDomain(RolRequestDto dto);

	RolResponseDto toResponseDto(Rol rolPojo);

}
