package com.uisrael.asistencia.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IAuditoriaUseCase;
import com.uisrael.asistencia.aplicacion.casosuso.entrada.ICodigosTemporalesUseCase;
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IEmpleadoHorarioUseCase;
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IEmpleadoUseCase;
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IHorariosUseCase;
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IMarcacionesUsaCase;
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IUbicacionUseCase;
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IReporteDiarioUseCase;
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IRolUseCase;
import com.uisrael.asistencia.aplicacion.casosuso.impl.AuditoriaUseCaseImpl;
import com.uisrael.asistencia.aplicacion.casosuso.impl.CodigosTemporalesUseCaseImpl;
import com.uisrael.asistencia.aplicacion.casosuso.impl.EmpleadoHorarioUseCaseImpl;
import com.uisrael.asistencia.aplicacion.casosuso.impl.EmpleadoUseCaseImpl;
import com.uisrael.asistencia.aplicacion.casosuso.impl.HorariosUseCaseImpl;
import com.uisrael.asistencia.aplicacion.casosuso.impl.MarcacionesUseCaseImpl;
import com.uisrael.asistencia.aplicacion.casosuso.impl.UbicacionUseCaseImpl;
import com.uisrael.asistencia.aplicacion.casosuso.impl.ReporteDiarioUseCaseImpl;
import com.uisrael.asistencia.aplicacion.casosuso.impl.RolUseCaseImpl;
import com.uisrael.asistencia.dominio.repositorio.IAuditoriaRepositorio;
import com.uisrael.asistencia.dominio.repositorio.ICodigosTemporalesRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IEmpleadoHorarioRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IEmpleadoRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IHorariosRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IMarcacionesRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IUbicacionRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IReporteDiarioRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IRolRepositorio;
import com.uisrael.asistencia.infraestructura.correo.EmailService;
import com.uisrael.asistencia.infraestructura.persistencia.adaptadores.AuditoriaRepositorioImpl;
import com.uisrael.asistencia.infraestructura.persistencia.adaptadores.CodigosTempralesRepositorioImpl;
import com.uisrael.asistencia.infraestructura.persistencia.adaptadores.EmpleadoHorarioRepositorioImpl;
import com.uisrael.asistencia.infraestructura.persistencia.adaptadores.EmpleadoRepositorioImpl;
import com.uisrael.asistencia.infraestructura.persistencia.adaptadores.HorariosRepositorioImpl;
import com.uisrael.asistencia.infraestructura.persistencia.adaptadores.MarcacionesRepositorioImpl;
import com.uisrael.asistencia.infraestructura.persistencia.adaptadores.UbicacionRepositorioImpl;
import com.uisrael.asistencia.infraestructura.persistencia.adaptadores.ReporteDiarioRepositorioImpl;
import com.uisrael.asistencia.infraestructura.persistencia.adaptadores.RolRepositorioImpl;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IAuditoriaJpaMapper;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.ICodigosTemporalesJpaMapper;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IEmpleadoHorarioJpaMapper;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IEmpleadoJpaMapper;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IHorariosJpaMapper;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IMarcacionesJpaMapper;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IUbicacionJpaMapper;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IReporteDiarioJpaMapper;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IRolJpaMapper;
import com.uisrael.asistencia.infraestructura.repositorios.IAuditoriaJpaRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.ICodigosTemporalesJpaRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.IEmpleadoHorarioJpaRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.IEmpleadoJpaRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.IHorariosJpaRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.IMarcacionesJpaRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.IUbicacionJpaRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.IReporteDiarioJpaRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.IRolJpaRepositorio;
import com.uisrael.asistencia.infraestructura.seguridad.JwtUtil;


@Configuration
public class AsistenciaConfig {
	// ** Empleado
	@Bean
	IEmpleadoRepositorio empleadoRepositorio(IEmpleadoJpaRepositorio jpaRepositorio, IEmpleadoJpaMapper mapper) {
		return new EmpleadoRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IEmpleadoUseCase empleadoUseCase(IEmpleadoRepositorio repo) {
		return new EmpleadoUseCaseImpl(repo);
	}

	// ** Ubicacion
	@Bean
	IUbicacionRepositorio ubicacionRepositorio(IUbicacionJpaRepositorio jpaRepositorio, IUbicacionJpaMapper mapper) {
		return new UbicacionRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IUbicacionUseCase ubicacionUseCase(IUbicacionRepositorio repo) {
		return new UbicacionUseCaseImpl(repo);
	}

	// ** Marcaciones
	@Bean
	IMarcacionesRepositorio marcacionesRepositorio(IMarcacionesJpaRepositorio jpaRepositorio,
			IMarcacionesJpaMapper mapper) {
		return new MarcacionesRepositorioImpl(jpaRepositorio, mapper);
	}
	@Bean
	IMarcacionesUsaCase marcacionesUseCase(IMarcacionesRepositorio repo,
			ICodigosTemporalesRepositorio codigosTemporalesRepositorio,
			IEmpleadoRepositorio empleadoRepositorio,
			IUbicacionRepositorio ubicacionRepositorio,
			IEmpleadoHorarioRepositorio empleadoHorarioRepositorio,
			IHorariosRepositorio horariosRepositorio,
			JwtUtil jwtUtil,
			EmailService emailService,
			IReporteDiarioUseCase reporteDiarioUseCase) {
		return new MarcacionesUseCaseImpl(repo, codigosTemporalesRepositorio, empleadoRepositorio,
				ubicacionRepositorio, empleadoHorarioRepositorio, horariosRepositorio,
				jwtUtil, emailService, reporteDiarioUseCase);
	}

	/* Horarios */
	@Bean
	IHorariosRepositorio horariosRepositorio(IHorariosJpaRepositorio jpaRepositorio, IHorariosJpaMapper mapper) {
		return new HorariosRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IHorariosUseCase horariosUseCase(IHorariosRepositorio repo) {
		return new HorariosUseCaseImpl(repo);
	}

	/* CodigosTemporales */
	@Bean
	ICodigosTemporalesRepositorio codigosTemporalesRepositorio(ICodigosTemporalesJpaRepositorio jpaRepositorio,
			ICodigosTemporalesJpaMapper mapper) {
		return new CodigosTempralesRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	ICodigosTemporalesUseCase codigosTemporalesUseCase(ICodigosTemporalesRepositorio repo) {
		return new CodigosTemporalesUseCaseImpl(repo);
	}

	/* EmpleadoHorario */
	@Bean
	IEmpleadoHorarioRepositorio empleadoHorarioRepositorio(IEmpleadoHorarioJpaRepositorio jpaRepositorio,
			IEmpleadoHorarioJpaMapper mapper) {
		return new EmpleadoHorarioRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IEmpleadoHorarioUseCase empleadoHorarioUseCase(IEmpleadoHorarioRepositorio repo) {
		return new EmpleadoHorarioUseCaseImpl(repo);
	}
	
	/*Auditoria*/
	@Bean
	IAuditoriaRepositorio auditoriaRepositorio(IAuditoriaJpaRepositorio jpaRepositorio, IAuditoriaJpaMapper mapper) {
		return new AuditoriaRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IAuditoriaUseCase auditoriaUseCase(IAuditoriaRepositorio repo) {
		return new AuditoriaUseCaseImpl(repo);
	}
	
	/*ReporteDiario*/
	@Bean
	IReporteDiarioRepositorio reporteDiarioRepositorio(IReporteDiarioJpaRepositorio jpaRepositorio, IReporteDiarioJpaMapper mapper) {
		return new ReporteDiarioRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IReporteDiarioUseCase reporteDiarioUseCase(IReporteDiarioRepositorio repo,
			IMarcacionesRepositorio marcacionesRepositorio,
			IEmpleadoHorarioRepositorio empleadoHorarioRepositorio,
			IHorariosRepositorio horariosRepositorio) {
		return new ReporteDiarioUseCaseImpl(repo, marcacionesRepositorio, empleadoHorarioRepositorio, horariosRepositorio);
	}
	
	/*Rol*/
	@Bean
	IRolRepositorio rolRepositorio(IRolJpaRepositorio jpaRepositorio, IRolJpaMapper mapper) {
		return new RolRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IRolUseCase rolUseCase(IRolRepositorio repo) {
		return new RolUseCaseImpl(repo);
	}
	
}
