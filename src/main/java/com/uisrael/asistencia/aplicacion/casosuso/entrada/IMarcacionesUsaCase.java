package com.uisrael.asistencia.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.asistencia.dominio.entidades.Marcaciones;

public interface IMarcacionesUsaCase {

	Marcaciones guardar(Marcaciones nuevaMarcacion);

	Marcaciones buscarPorId(int idMarcaciones);

	List<Marcaciones> listarTodos();

	void eliminar(int idMarcaciones);
}
