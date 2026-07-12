package com.uisrael.asistencia.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.AuditoriaEntity;

public interface IAuditoriaJpaRepositorio extends JpaRepository<AuditoriaEntity, Long> {

    @Query("Select a from AuditoriaEntity a where a.fkEmpleadoEntity.idEmpleado=?1")
    List<AuditoriaEntity> buscarPorEmpleado(int idEmpleado);

    @Query("Select a from AuditoriaEntity a where a.tablaAfectada=?1")
    List<AuditoriaEntity> buscarPorTabla(String tabla);
    
    @Query("Select a from AuditoriaEntity a where a.ip=?1")
    List<AuditoriaEntity> buscarPorIp(String ip);

    @Query("Select a from AuditoriaEntity a where a.accion=?1")
    List<AuditoriaEntity> buscarPorAccion(String accion);
}