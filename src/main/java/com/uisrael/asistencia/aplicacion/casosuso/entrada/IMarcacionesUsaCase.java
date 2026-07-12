package com.uisrael.asistencia.aplicacion.casosuso.entrada;

import java.time.LocalDate;
import java.util.List;

import com.uisrael.asistencia.dominio.entidades.Marcaciones;

public interface IMarcacionesUsaCase {

	Marcaciones guardar(Marcaciones nuevaMarcacion);

	Marcaciones buscarPorId(int idMarcaciones);

	List<Marcaciones> listarTodos();

	void eliminar(int idMarcaciones);

	List<Marcaciones> buscarPorEmpleado(int idEmpleado);

	List<Marcaciones> buscarPorEmpleadoYFecha(int idEmpleado, LocalDate fecha);

	List<Marcaciones> buscarPorTipo(String tipo);

	List<Marcaciones> listarMarcacionesValidas();

	List<Marcaciones> listarMarcacionesCorrectas();
}
