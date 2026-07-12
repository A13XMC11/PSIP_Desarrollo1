package com.uisrael.asistencia.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.asistencia.dominio.entidades.Empleado;

public interface IEmpleadoUseCase {

	Empleado guardar(Empleado nuevoEmpleado);

	Empleado buscarPorId(int idEmpleado);

	List<Empleado> listarTodos();

	void eliminar(int idEmpleado);

	List<Empleado> findByCorreoEmpleado(String correo);

	List<Empleado> listarEmpleadosActivos();

	List<Empleado> buscarPorRol(int idRol);

	List<Empleado> buscarPorNombre(String nombre);
	
	List<Empleado> buscarPorApellido(String apellido);
}
