package com.uisrael.asistencia.infraestructura.repositorios;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.CodigosTemporalesEntity;

public interface ICodigosTemporalesJpaRepositorio extends JpaRepository<CodigosTemporalesEntity, Integer>{
	@Query("Select c from CodigosTemporalesEntity c where c.codigo=?1 and c.idEmpleado=?2 and c.usado=false and c.expiraEn>?3")
	Optional<CodigosTemporalesEntity> validarCodigo(String codigo, int idEmpleado, LocalDateTime ahora);
	
	 @Query("Select c from CodigosTemporalesEntity c where c.fkEmpleadoEntity.idEmpleado=?1 and c.usado=false")
	 List<CodigosTemporalesEntity> buscarCodigosActivosPorEmpleado(int idEmpleado);
}
