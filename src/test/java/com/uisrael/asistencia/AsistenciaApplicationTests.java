package com.uisrael.asistencia;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.AuditoriaEntity;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.CodigosTemporalesEntity;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.EmpleadoEntity;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.EmpleadoHorarioEntity;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.HorariosEntity;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.ReporteDiarioEntity;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.RolEntity;
import com.uisrael.asistencia.infraestructura.repositorios.IAuditoriaRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.ICodigosTemporalesRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.IEmpleadoHorarioRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.IEmpleadoRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.IHorariosRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.IReporteDiarioRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.IRolRepositorio;

@SpringBootTest
class AsistenciaApplicationTests {
	
	@Autowired
	IEmpleadoRepositorio repoEmpleado;
	@Autowired 
	IHorariosRepositorio repoHorario;
	@Autowired
	ICodigosTemporalesRepositorio repoCodigoTemporal;
	@Autowired
	IEmpleadoHorarioRepositorio repoEmpleadoHorario;
	@Autowired
	IRolRepositorio repoRol;
	@Autowired
	IReporteDiarioRepositorio repoReporte;
	@Autowired
	IAuditoriaRepositorio repoAuditoria;
	
	@Test
	void contextLoads() {
		
		EmpleadoEntity nuevoEmp = new EmpleadoEntity();
		nuevoEmp.setNombreEmpleado("Alexander");
		nuevoEmp.setApellidosEmpleado("Mejia Cevallos");
		nuevoEmp.setCorreoEmpleado("alexander777800@gmail.com");
		nuevoEmp.setContrasenaEmpleado("Test123");
		repoEmpleado.save(nuevoEmp);
		
		System.out.println(nuevoEmp.getNombreEmpleado()+" "+nuevoEmp.getApellidosEmpleado()+" "+nuevoEmp.getCorreoEmpleado()+" "+nuevoEmp.getContrasenaEmpleado());
		
		//HORARIOS
		HorariosEntity nuevoHora = new HorariosEntity();
		nuevoHora.setNombre("Horario Matutino");
		nuevoHora.setHoraEntrada(LocalTime.parse("08:00"));
		nuevoHora.setHoraSalida(LocalTime.parse("17:00"));
		nuevoHora.setToleranciaMinutos(10);
		nuevoHora.setEstadoHorario(true);
		repoHorario.save(nuevoHora);
		
		System.out.println(nuevoHora.getNombre()+" "+nuevoHora.getHoraEntrada()+" "+nuevoHora.getHoraSalida()+" "+nuevoHora.getToleranciaMinutos()+" "+nuevoHora.isEstadoHorario());
		
		//Codigos temporales
		CodigosTemporalesEntity nuevoCodigo = new CodigosTemporalesEntity();
		nuevoCodigo.setCodigo("ABC123");
		nuevoCodigo.setTipo("ENTRADA");
		nuevoCodigo.setGeneradoEn(LocalDateTime.now());
		nuevoCodigo.setExpiraEn(LocalDateTime.now().plusMinutes(10));
		nuevoCodigo.setUsado(false);
		repoCodigoTemporal.save(nuevoCodigo);		
		
		System.out.println(nuevoCodigo.getCodigo()+" "+nuevoCodigo.getTipo()+" "+nuevoCodigo.getGeneradoEn()+" "+nuevoCodigo.getExpiraEn()+" "+nuevoCodigo.isUsado());
		
		//EMPLEADO HORARIO
		EmpleadoHorarioEntity nuevaAsignacion = new EmpleadoHorarioEntity();
		nuevaAsignacion.setIdEmpleado(1);
		nuevaAsignacion.setIdHorario(1);
		nuevaAsignacion.setFechaInicio(Date.valueOf("2026-06-01"));
		nuevaAsignacion.setFechaFin(Date.valueOf("2026-12-31"));
		nuevaAsignacion.setEstadoEmpleadoHorario(true);
		repoEmpleadoHorario.save(nuevaAsignacion);
		
		System.out.println(nuevaAsignacion.getIdEmpleado()+" "+nuevaAsignacion.getIdHorario()+" "+nuevaAsignacion.getFechaInicio()+" "+nuevaAsignacion.getFechaFin()+" "+nuevaAsignacion.isEstadoEmpleadoHorario());
		
		//Rol 
		RolEntity nuevoRol = new RolEntity();
		nuevoRol.setNombre("Administrador");
		nuevoRol.setDescripcion("Acceso total al sistema");
		nuevoRol.setCreadoRol(LocalDateTime.now());
		repoRol.save(nuevoRol);
		
		System.out.println(nuevoRol.getNombre()+" "+nuevoRol.getDescripcion()+" "+nuevoRol.getCreadoRol());
		
		//Reporte Diario
		ReporteDiarioEntity nuevoReporte = new ReporteDiarioEntity();
		nuevoReporte.setIdEmpelado(1);
		nuevoReporte.setFechaReporte(LocalDate.now());
		nuevoReporte.setHoraEntrada(LocalTime.parse("08:05"));
		nuevoReporte.setHoraSalida(LocalTime.parse("17:00"));
		nuevoReporte.setTardanzaReporte(true);
		nuevoReporte.setMinutosTardanza(5);
		nuevoReporte.setMarcacionImcompleta(false);
		repoReporte.save(nuevoReporte);
		
		System.out.println(nuevoReporte.getIdEmpelado()+" "+nuevoReporte.getFechaReporte()+" "+nuevoReporte.getHoraEntrada()+" "+nuevoReporte.getHoraSalida()+" "+nuevoReporte.isTardanzaReporte());
		
		//Auditoria
		AuditoriaEntity nuevaAuditoria = new AuditoriaEntity();
		nuevaAuditoria.setIdEmpleado(1);
		nuevaAuditoria.setAccion("Insert");
		nuevaAuditoria.setTablaAfectada("Empleado");
		nuevaAuditoria.setRegistroId(1);
		nuevaAuditoria.setDetalle("Se registro un nuevo empleado");
		nuevaAuditoria.setIp("192.168.1.10");
		nuevaAuditoria.setFechaHora(LocalDateTime.now());
		repoAuditoria.save(nuevaAuditoria);
		
		System.out.println(nuevaAuditoria.getAccion()+" "+nuevaAuditoria.getTablaAfectada()+" "+nuevaAuditoria.getDetalle()+" "+nuevaAuditoria.getFechaHora());
		
	}

}
	