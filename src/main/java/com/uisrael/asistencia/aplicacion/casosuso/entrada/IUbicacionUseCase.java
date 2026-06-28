package com.uisrael.asistencia.aplicacion.casosuso.entrada;

import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.Ubicacion;

public interface IUbicacionUseCase {
	Ubicacion guardar(Ubicacion nuevaUbicacion);

	Ubicacion buscarPorId(int idUbicacion);

	List<Ubicacion> listarTodos();

	void eliminar(int idUbicacion);
}
