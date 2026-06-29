package com.uisrael.asistencia.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.asistencia.dominio.entidades.ReporteDiario;

import com.uisrael.asistencia.presentacion.dto.request.ReporteDiarioRequestDto;

import com.uisrael.asistencia.presentacion.dto.response.ReporteDiarioResponseDto;

@Mapper(componentModel = "spring")
public interface IReporteDiarioDtoMapper {

	ReporteDiario toDomain(ReporteDiarioRequestDto dto);

	ReporteDiarioResponseDto toResponseDto(ReporteDiario reporteDiaroPojo);
}
