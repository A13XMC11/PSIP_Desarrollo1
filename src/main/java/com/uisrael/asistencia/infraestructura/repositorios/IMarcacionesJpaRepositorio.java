package com.uisrael.asistencia.infraestructura.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.MarcacionesEntity;

public interface IMarcacionesJpaRepositorio extends JpaRepository<MarcacionesEntity, Integer> {

	@Query("Select m from MarcacionesEntity m where m.fkEmpleadoEntity.idEmpleado=?1")
	List<MarcacionesEntity> buscarPorEmpleado(int idEmpleado);

	@Query("Select m from MarcacionesEntity m where m.fkEmpleadoEntity.idEmpleado=?1 and m.fechaMarcacion=?2")
	List<MarcacionesEntity> buscarPorEmpleadoYFecha(int idEmpleado, LocalDate fecha);

	@Query("Select m from MarcacionesEntity m where m.tipo=?1")
	List<MarcacionesEntity> buscarPorTipo(String tipo);

	@Query("Select m from MarcacionesEntity m where m.valida=true")
	List<MarcacionesEntity> listarMarcacionesValidas();

	@Query("Select m from MarcacionesEntity m where m.dentroRango=true and m.dentroHorario=true")
	List<MarcacionesEntity> listarMarcacionesCorrectas();
}
