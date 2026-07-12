package com.uisrael.asistencia.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.asistencia.dominio.entidades.Auditoria;

public interface IAuditoriaUseCase {

	Auditoria guardar(Auditoria nuevaAuditoria);

	Auditoria buscarPorId(Long idAuditoria);

	List<Auditoria> listarTodos();

	void eliminar(Long idAuditoria);

	List<Auditoria> buscarPorEmpleado(int idEmpleado);

	List<Auditoria> buscarPorTabla(String tabla);

	List<Auditoria> buscarPorIp(String ip);

	List<Auditoria> buscarPorAccion(String accion);
}
