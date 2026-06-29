package com.uisrael.asistencia.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.ICodigosTemporalesUseCase;
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IEmpleadoHorarioUseCase;
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IHorariosUseCase;
import com.uisrael.asistencia.aplicacion.casosuso.impl.CodigosTemporalesUseCaseImpl;
import com.uisrael.asistencia.aplicacion.casosuso.impl.EmpleadoHorarioUseCaseImpl;
import com.uisrael.asistencia.aplicacion.casosuso.impl.HorariosUseCaseImpl;
import com.uisrael.asistencia.dominio.repositorio.ICodigosTemporalesRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IEmpleadoHorarioRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IHorariosRepositorio;
import com.uisrael.asistencia.infraestructura.persistencia.adaptadores.CodigosTempralesRepositorioImpl;
import com.uisrael.asistencia.infraestructura.persistencia.adaptadores.EmpleadoHorarioRepositorioImpl;
import com.uisrael.asistencia.infraestructura.persistencia.adaptadores.HorariosRepositorioImpl;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.ICodigosTemporalesJpaMapper;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IEmpleadoHorarioJpaMapper;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IHorariosJpaMapper;
import com.uisrael.asistencia.infraestructura.repositorios.ICodigosTemporalesJpaRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.IEmpleadoHorarioJpaRepositorio;
import com.uisrael.asistencia.infraestructura.repositorios.IHorariosJpaRepositorio;

@Configuration
public class AsistenciaConfig {
	/*Horarios*/
	@Bean 
	IHorariosRepositorio horariosRepositorio(IHorariosJpaRepositorio jpaRepositorio, IHorariosJpaMapper mapper) {
		return new HorariosRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IHorariosUseCase horariosUseCase(IHorariosRepositorio repo) {
		return new HorariosUseCaseImpl(repo);
	}
	
	/*CodigosTemporales*/
	@Bean
	ICodigosTemporalesRepositorio codigosTemporalesRepositorio(ICodigosTemporalesJpaRepositorio jpaRepositorio, ICodigosTemporalesJpaMapper mapper) {
		return new CodigosTempralesRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	ICodigosTemporalesUseCase codigosTemporalesUseCase(ICodigosTemporalesRepositorio repo) {
		return new CodigosTemporalesUseCaseImpl(repo);
	}
	
	/*EmpleadoHorario*/
	@Bean
	IEmpleadoHorarioRepositorio empleadoHorarioRepositorio(IEmpleadoHorarioJpaRepositorio jpaRepositorio, IEmpleadoHorarioJpaMapper mapper) {
		return new EmpleadoHorarioRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IEmpleadoHorarioUseCase empleadoHorarioUseCase(IEmpleadoHorarioRepositorio repo) {
		return new EmpleadoHorarioUseCaseImpl(repo);
	}
}
