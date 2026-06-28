package com.uisrael.asistencia.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.Marcaciones;

public interface IMarcacionesRepositorio {
	
	Marcaciones guardar(Marcaciones nuevaMarcacion);
	
	Optional<Marcaciones> buscarPorId(int idMarcaciones);
	
	List<Marcaciones> listarTodos();
	
	void eliminar(int idMarcaciones);

}
