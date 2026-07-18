package com.uisrael.asistencia.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.asistencia.dominio.entidades.CodigosTemporales;

public interface ICodigosTemporalesUseCase {
	
	CodigosTemporales guardar(CodigosTemporales nuevoCodigo);

	CodigosTemporales buscarPorId(int idCodigoTemporal);

	List<CodigosTemporales> listarTodos();

	void eliminar(int idCodigosTemporales);
	
	CodigosTemporales validarCodigo(String codigo, int idEmpleado);
	
    List<CodigosTemporales> buscarCodigosActivosPorEmpleado(int idEmpleado);
}
