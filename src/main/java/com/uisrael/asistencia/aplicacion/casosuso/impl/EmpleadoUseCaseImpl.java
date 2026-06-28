package com.uisrael.asistencia.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IEmpleadoUseCase;
import com.uisrael.asistencia.dominio.entidades.Empleado;
import com.uisrael.asistencia.dominio.repositorio.IEmpleadoRepositorio;

public class EmpleadoUseCaseImpl implements IEmpleadoUseCase {

	private final IEmpleadoRepositorio repositorio;

	public EmpleadoUseCaseImpl(IEmpleadoRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Empleado guardar(Empleado nuevoEmpleado) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevoEmpleado);
	}

	@Override
	public Empleado buscarPorId(int idEmpleado) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idEmpleado).orElseThrow(() -> new RuntimeException("No se encontro Empleado"));
	}

	@Override
	public List<Empleado> listarTodos() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idEmpleado) {
		repositorio.eliminar(idEmpleado);

	}

}
