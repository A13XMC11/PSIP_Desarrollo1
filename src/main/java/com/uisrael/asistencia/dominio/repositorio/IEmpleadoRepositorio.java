package com.uisrael.asistencia.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.Empleado;

public interface IEmpleadoRepositorio {
	
	Empleado guardar(Empleado nuevoEmpleado);

	Optional<Empleado> buscarPorId(int idEmpleado);

	List<Empleado> listarTodos();

	void eliminar(int idEmpleado);
}
