package com.uisrael.asistencia.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.asistencia.dominio.entidades.Auditoria;


public interface IAuditoriaUseCase {
	
	Auditoria guardar(Auditoria nuevaAuditoria);

	Auditoria buscarPorId(int idAuditoria);

	List<Auditoria> listarTodos();

	void eliminar(int idAuditoria);

}
