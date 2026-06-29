package com.uisrael.asistencia.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.EmpleadoHorario;

public interface IEmpleadoHorarioRepositorio {

	EmpleadoHorario guardar(EmpleadoHorario nuevoEmpleadoHorario);

	Optional<EmpleadoHorario> buscarPorId(int idEmpleadoHorario);

	List<EmpleadoHorario> listarTodos();

	void eliminar(int idEmpleadoHorario);
}
