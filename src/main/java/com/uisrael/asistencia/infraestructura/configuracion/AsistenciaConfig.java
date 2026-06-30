package com.uisrael.asistencia.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.ICodigosTemporalesUseCase;
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IEmpleadoHorarioUseCase;
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IEmpleadoUseCase;
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IHorariosUseCase;
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IMarcacionesUsaCase;
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IUbicacionUseCase;
import com.uisrael.asistencia.aplicacion.casosuso.impl.CodigosTemporalesUseCaseImpl;
import com.uisrael.asistencia.aplicacion.casosuso.impl.EmpleadoHorarioUseCaseImpl;
import com.uisrael.asistencia.aplicacion.casosuso.impl.EmpleadoUseCaseImpl;
import com.uisrael.asistencia.aplicacion.casosuso.impl.HorariosUseCaseImpl;
import com.uisrael.asistencia.aplicacion.casosuso.impl.MarcacionesUseCaseImpl;
import com.uisrael.asistencia.aplicacion.casosuso.impl.UbicacionUseCaseImpl;
import com.uisrael.asistencia.dominio.repositorio.ICodigosTemporalesRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IEmpleadoHorarioRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IEmpleadoRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IHorariosRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IMarcacionesRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IUbicacionRepositorio;
import com.uisrael.asistencia.infraestructura.persistencia.adaptadores.CodigosTempralesRepositorioImpl;
import com.uisrael.asistencia.infraestructura.persistencia.adaptadores.EmpleadoHorarioRepositorioImpl;
import com.uisrael.asistencia.infraestructura.persistencia.adaptadores.EmpleadoRepositorioImpl;
import com.uisrael.asistencia.infraestructura.persistencia.adaptadores.HorariosRepositorioImpl;
import com.uisrael.asistencia.infraestructura.persistencia.adaptadores.MarcacionesRepositorioImpl;
import com.uisrael.asistencia.infraestructura.persistencia.adaptadores.UbicacionRepositorioImpl;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.ICodigosTemporalesJpaMapper;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IEmpleadoHorarioJpaMapper;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IEmpleadoJpaMapper;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IHorariosJpaMapper;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IMarcacionesJpaMapper;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IUbicacionJpaMapper;
import com.uisrael.asistencia.infraestructura.repositorios.ICodigosTemporalesJpaRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.IEmpleadoHorarioJpaRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.IEmpleadoJpaRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.IHorariosJpaRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.IMarcacionesJpaRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.IUbicacionJpaRepositorio;

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

	IUbicacionRepositorio ubicacionRepositorio(IUbicacionJpaRepositorio jpaRepositorio, IUbicacionJpaMapper mapper) {
		return new UbicacionRepositorioImpl(jpaRepositorio, mapper);
	}

	IUbicacionUseCase ubicacionUseCase(IUbicacionRepositorio repo) {
		return new UbicacionUseCaseImpl(repo);
	}

	// ** Marcaciones

	IMarcacionesRepositorio marcacionesRepositorio(IMarcacionesJpaRepositorio jpaRepositorio,
			IMarcacionesJpaMapper mapper) {
		return new MarcacionesRepositorioImpl(jpaRepositorio, mapper);
	}
	
	IMarcacionesUsaCase marcacionesUsaCase(IMarcacionesRepositorio repo) {
		return new MarcacionesUseCaseImpl(repo);
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
}
