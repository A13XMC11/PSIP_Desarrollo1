package com.uisrael.asistencia.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.Horarios;

public interface IHorariosRepositorio {
	
	Horarios guardar(Horarios nuevoHorario);

	Optional<Horarios> buscarPorId(int idHorarios);

	List<Horarios> listarTodos();

	void eliminar(int idHorarios);
}
