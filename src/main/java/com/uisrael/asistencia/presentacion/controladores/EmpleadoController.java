package com.uisrael.asistencia.presentacion.controladores;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IEmpleadoUseCase;
import com.uisrael.asistencia.presentacion.mapeadores.IEmpleadoDtoMapper;

public class EmpleadoController {
	private final IEmpleadoUseCase empleadoUseCase;
	private final IEmpleadoDtoMapper mapper;
	
	public EmpleadoController(IEmpleadoUseCase empleadoUseCase, IEmpleadoDtoMapper mapper) {
		super();
		this.empleadoUseCase = empleadoUseCase;
		this.mapper = mapper;
	}
	
	
}
