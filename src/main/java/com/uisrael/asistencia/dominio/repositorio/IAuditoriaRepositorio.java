package com.uisrael.asistencia.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.Auditoria;

public interface IAuditoriaRepositorio {

	Auditoria guardar(Auditoria nuevaAuditoria);

	Optional<Auditoria> buscarPorId(Long idAuditoria);

	List<Auditoria> listarTodos();

	void eliminar(Long idAuditoria);

	List<Auditoria> buscarPorEmpleado(int idEmpleado);

	List<Auditoria> buscarPorTabla(String tabla);

	List<Auditoria> buscarPorIp(String ip);

	List<Auditoria> buscarPorAccion(String accion);

}
