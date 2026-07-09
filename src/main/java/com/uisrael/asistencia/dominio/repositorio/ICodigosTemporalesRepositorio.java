package com.uisrael.asistencia.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.CodigosTemporales;

public interface ICodigosTemporalesRepositorio {

	CodigosTemporales guardar(CodigosTemporales nuevoCodigo);

	Optional<CodigosTemporales> buscarPorId(int idCodigosTemporales);

	List<CodigosTemporales> listarTodos();

	void eliminar(int idCodigosTemporales);
	
	Optional<CodigosTemporales> validarCodigo(String codigo, int idEmpleado);
}
