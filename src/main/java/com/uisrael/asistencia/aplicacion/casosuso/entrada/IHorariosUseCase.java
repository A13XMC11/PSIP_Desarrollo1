package com.uisrael.asistencia.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.asistencia.dominio.entidades.Horarios;

public interface IHorariosUseCase {

	Horarios guardar(Horarios nuevoHorario);

	Horarios buscarPorId(int idHorarios);

	List<Horarios> listarTodos();

	void eliminar(int idHorarios);
}
