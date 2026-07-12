package com.uisrael.asistencia.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.Ubicacion;

public interface IUbicacionRepositorio {

	Ubicacion guardar(Ubicacion nuevaUbicacion);

	Optional<Ubicacion> buscarPorId(int idUbicacion);

	List<Ubicacion> listarTodos();

	void eliminar(int idUbicacion);

	List<Ubicacion> listarUbicacionesActivas();

	List<Ubicacion> findByNombreUbicacion(String nombre);
}
