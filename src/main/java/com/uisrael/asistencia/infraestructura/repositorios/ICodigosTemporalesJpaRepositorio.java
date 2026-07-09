package com.uisrael.asistencia.infraestructura.repositorios;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.CodigosTemporalesEntity;

public interface ICodigosTemporalesJpaRepositorio extends JpaRepository<CodigosTemporalesEntity, Integer>{
	@Query("Select c from CodigosTemporalesEntity c where c.codigo=?1 and c.idEmpleado=?2 and c.usado=false and c.expiraEn>?3")
	Optional<CodigosTemporalesEntity> validarCodigo(String codigo, int idEmpleado, LocalDateTime ahora);
}
