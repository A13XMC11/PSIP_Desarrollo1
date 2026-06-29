package com.uisrael.asistencia.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.asistencia.dominio.entidades.EmpleadoHorario;

public interface IEmpleadoHorarioUseCase {
	
	EmpleadoHorario guardar(EmpleadoHorario nuevoEmpleadoHorario);

	EmpleadoHorario buscarPorId(int idEmpleadoHorario);

	List<EmpleadoHorario> listarTodos();

	void eliminar(int idEmpleadoHorario);
}
