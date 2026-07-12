package com.uisrael.asistencia.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.asistencia.dominio.entidades.Rol;

public interface IRolUseCase {

	Rol guardar(Rol nuevoRol);

	Rol buscarPorId(int idRol);

	List<Rol> listarTodos();

	void eliminar(int idRol);

	List<Rol> buscarPorNombre(String nombre);
}