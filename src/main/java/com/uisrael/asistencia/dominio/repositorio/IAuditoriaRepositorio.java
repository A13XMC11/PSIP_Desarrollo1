package com.uisrael.asistencia.dominio.repositorio;

import java.util.List;
import java.util.Optional;
import com.uisrael.asistencia.dominio.entidades.Auditoria;


public interface IAuditoriaRepositorio {

	Auditoria guardar(Auditoria nuevaAuditoria);

	Optional<Auditoria> buscarPorId(int idAuditoria);

	List<Auditoria> listarTodos();

	void eliminar(int idAuditoria);
}
