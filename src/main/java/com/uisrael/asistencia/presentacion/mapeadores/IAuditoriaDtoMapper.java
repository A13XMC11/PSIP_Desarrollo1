package com.uisrael.asistencia.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.asistencia.dominio.entidades.Auditoria;
import com.uisrael.asistencia.presentacion.dto.request.AuditoriaRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.AuditoriaResponseDto;

@Mapper(componentModel = "spring")
public interface IAuditoriaDtoMapper {
	Auditoria toDomain(AuditoriaRequestDto dto);

	AuditoriaResponseDto toResponseDto(Auditoria auditoriaPojo);

}
