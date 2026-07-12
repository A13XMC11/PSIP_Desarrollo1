package com.uisrael.asistencia.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.Rol;

public interface IRolRepositorio {

	Rol guardar(Rol nuevoRol);

	Optional<Rol> buscarPorId(int idRol);

	List<Rol> listarTodos();

	void eliminar(int idRol);

	List<Rol> findByNombre(String nombre);
}
