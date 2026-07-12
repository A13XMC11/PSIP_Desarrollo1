package com.uisrael.asistencia.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.EmpleadoEntity;

public interface IEmpleadoJpaRepositorio extends JpaRepository<EmpleadoEntity, Integer> {

	List<EmpleadoEntity> findByCorreoEmpleado(String correo);

	@Query("Select e from EmpleadoEntity e where e.estadoEmpleado=true")
	List<EmpleadoEntity> listarEmpleadosActivos();

	@Query("Select e from EmpleadoEntity e where e.fkRolEntity.idRol=?1")
	List<EmpleadoEntity> buscarPorRol(int idRol);

	@Query("Select e from EmpleadoEntity e where e.nombreEmpleado=?1")
	List<EmpleadoEntity> buscarPorNombre(String nombre);

	@Query("Select e from EmpleadoEntity e where e.apellidosEmpleado=?1")
	List<EmpleadoEntity> buscarPorApellido(String apellido);

}
