package com.uisrael.asistencia.aplicacion.casosuso.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IMarcacionesUsaCase;
import com.uisrael.asistencia.aplicacion.casosuso.entrada.IReporteDiarioUseCase;
import com.uisrael.asistencia.dominio.entidades.CodigosTemporales;
import com.uisrael.asistencia.dominio.entidades.Empleado;
import com.uisrael.asistencia.dominio.entidades.EmpleadoHorario;
import com.uisrael.asistencia.dominio.entidades.Horarios;
import com.uisrael.asistencia.dominio.entidades.Marcaciones;
import com.uisrael.asistencia.dominio.entidades.Ubicacion;
import com.uisrael.asistencia.dominio.repositorio.ICodigosTemporalesRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IEmpleadoHorarioRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IEmpleadoRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IHorariosRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IMarcacionesRepositorio;
import com.uisrael.asistencia.dominio.repositorio.IUbicacionRepositorio;
import com.uisrael.asistencia.infraestructura.correo.EmailService;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.CodigosTemporalesEntity;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.EmpleadoEntity;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.UbicacionEntity;
import com.uisrael.asistencia.infraestructura.seguridad.HaversineUtil;
import com.uisrael.asistencia.infraestructura.seguridad.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;

public class MarcacionesUseCaseImpl implements IMarcacionesUsaCase {

	private final IMarcacionesRepositorio repositorio;
	private final ICodigosTemporalesRepositorio codigosTemporalesRepositorio;
	private final IEmpleadoRepositorio empleadoRepositorio;
	private final IUbicacionRepositorio ubicacionRepositorio;
	private final IEmpleadoHorarioRepositorio empleadoHorarioRepositorio;
	private final IHorariosRepositorio horariosRepositorio;
	private final JwtUtil jwtUtil;
	private final EmailService emailService;
	private final IReporteDiarioUseCase reporteDiarioUseCase;

	public MarcacionesUseCaseImpl(IMarcacionesRepositorio repositorio,
			ICodigosTemporalesRepositorio codigosTemporalesRepositorio, IEmpleadoRepositorio empleadoRepositorio,
			IUbicacionRepositorio ubicacionRepositorio, IEmpleadoHorarioRepositorio empleadoHorarioRepositorio,
			IHorariosRepositorio horariosRepositorio, JwtUtil jwtUtil, EmailService emailService,
			IReporteDiarioUseCase reporteDiarioUseCase) {
		super();
		this.repositorio = repositorio;
		this.codigosTemporalesRepositorio = codigosTemporalesRepositorio;
		this.empleadoRepositorio = empleadoRepositorio;
		this.ubicacionRepositorio = ubicacionRepositorio;
		this.empleadoHorarioRepositorio = empleadoHorarioRepositorio;
		this.horariosRepositorio = horariosRepositorio;
		this.jwtUtil = jwtUtil;
		this.emailService = emailService;
		this.reporteDiarioUseCase = reporteDiarioUseCase;
	}

	@Override
	public Marcaciones guardar(Marcaciones nuevaMarcacion) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevaMarcacion);
	}

	@Override
	public Marcaciones buscarPorId(int idMarcaciones) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idMarcaciones)
				.orElseThrow(() -> new RuntimeException("No se encontraron marcaciones"));
	}

	@Override
	public List<Marcaciones> listarTodos() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idMarcaciones) {
		repositorio.eliminar(idMarcaciones);

	}

	@Override
	public List<Marcaciones> buscarPorEmpleado(int idEmpleado) {
		return repositorio.buscarPorEmpleado(idEmpleado);
	}

	@Override
	public List<Marcaciones> buscarPorEmpleadoYFecha(int idEmpleado, LocalDate fecha) {
		return repositorio.buscarPorEmpleadoYFecha(idEmpleado, fecha);
	}

	@Override
	public List<Marcaciones> buscarPorTipo(String tipo) {
		return repositorio.buscarPorTipo(tipo);
	}

	@Override
	public List<Marcaciones> listarMarcacionesValidas() {
		return repositorio.listarMarcacionesValidas();
	}

	@Override
	public List<Marcaciones> listarMarcacionesCorrectas() {
		return repositorio.listarMarcacionesCorrectas();
	}

	@Override
	public List<Marcaciones> buscarPorUbicacion(int idUbicacion) {
		return repositorio.buscarPorUbicacion(idUbicacion);
	}

	@Override
	public void solicitarMarcacion(int idEmpleado, String tipo) {
		Empleado empleado = empleadoRepositorio.buscarPorId(idEmpleado)
				.orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

		CodigosTemporales codigo = new CodigosTemporales();
		codigo.setIdEmpleado(idEmpleado);
		codigo.setTipo(tipo);
		codigo.setCodigo(UUID.randomUUID().toString());
		codigo.setGeneradoEn(java.time.LocalDateTime.now());
		codigo.setExpiraEn(java.time.LocalDateTime.now().plusMinutes(10));
		codigo.setUsado(false);
		CodigosTemporales guardado = codigosTemporalesRepositorio.guardar(codigo);

		String token = jwtUtil.generarTokenMarcacion(idEmpleado, tipo, guardado.getIdCodigo());
		emailService.enviarLinkMarcacion(empleado.getCorreoEmpleado(), tipo, token);

	}

	@Override
	public Marcaciones registrarMarcacion(String token, double lat, double lng) {
		Claims claims;
		try {
			claims = jwtUtil.validarToken(token);
		} catch (ExpiredJwtException e) {
			throw new RuntimeException("El link expiró, solicita una nueva marcación");
		}

		int idEmpleado = claims.get("idEmpleado", Integer.class);
		String tipo = claims.get("tipo", String.class);
		int idCodigo = claims.get("idCodigo", Integer.class);

		CodigosTemporales codigo = codigosTemporalesRepositorio.buscarPorId(idCodigo)
				.orElseThrow(() -> new RuntimeException("Código no encontrado"));
		if (codigo.isUsado()) {
			throw new RuntimeException("Este link ya fue usado");
		}
		codigo.setUsado(true);
		codigosTemporalesRepositorio.guardar(codigo);

		// 1. Validar GPS de todas las ubicaciones activas
		List<Ubicacion> ubicacionesActivas = ubicacionRepositorio.listarUbicacionesActivas();
		Ubicacion ubicacionEncontrada = null;
		boolean dentroRango = false;
		for (Ubicacion u : ubicacionesActivas) {
			double distancia = HaversineUtil.calcularDistanciaMetros(lat, lng, u.getLatitudUbicacion(),
					u.getLongitudUbicacion());
			if (distancia <= u.getRadioMetrosUbicacion()) {
				dentroRango = true;
				ubicacionEncontrada = u;
				break;
			}
		}
		if (ubicacionEncontrada == null && !ubicacionesActivas.isEmpty()) {
			ubicacionEncontrada = ubicacionesActivas.get(0);
		}

		// 2. Validar horario asignado activo del empleado
		List<EmpleadoHorario> asignaciones = empleadoHorarioRepositorio.buscarHorariosActivosPorEmpleado(idEmpleado);
		boolean dentroHorario = false;
		String motivoHorario = "No tiene horario asignado";
		LocalTime horaActual = LocalTime.now();

		if (!asignaciones.isEmpty()) {
			Horarios horario = horariosRepositorio.buscarPorId(asignaciones.get(0).getIdHorario())
					.orElseThrow(() -> new RuntimeException("Horario no encontrado"));
			LocalTime toleranciaEntrada = horario.getHoraEntrada().plusMinutes(horario.getToleranciaMinutos());
			LocalTime toleranciaSalida = horario.getHoraSalida().minusMinutes(horario.getToleranciaMinutos());

			if (tipo.equals("ENTRADA")) {
				dentroHorario = !horaActual.isAfter(toleranciaEntrada);
			} else if (tipo.equals("SALIDA")) {
				dentroHorario = !horaActual.isBefore(toleranciaSalida);
			} else if (tipo.equals("SALIDA_ALMUERZO") || tipo.equals("REGRESO_ALMUERZO")) {
				boolean noAntesDeEntrada = !horaActual.isBefore(horario.getHoraEntrada());
				boolean noDespuesDeSalida = !horaActual.isAfter(horario.getHoraSalida());
				dentroHorario = noAntesDeEntrada && noDespuesDeSalida;
			} else {
				dentroHorario = false;
			}

			if (!dentroHorario) {
				motivoHorario = "Fuera del horario permitido para " + tipo;
			}
		}

		boolean valida = dentroRango && dentroHorario;
		String observacion;
		if (valida) {
			observacion = "OK";
		} else {
			observacion = "";
			if (!dentroRango) {
				observacion = observacion + "Fuera de rango GPS. ";
			}
			if (!dentroHorario) {
				observacion = observacion + motivoHorario;
			}
		}

		Marcaciones nueva = new Marcaciones();
		nueva.setTipo(tipo);
		nueva.setFechaMarcacion(new java.util.Date());
		nueva.setHoraMarcacion(horaActual);
		nueva.setLatitud((float) lat);
		nueva.setLongitud((float) lng);
		nueva.setDentroRango(dentroRango);
		nueva.setDentroHorario(dentroHorario);
		nueva.setValida(valida);
		nueva.setObservacion(observacion.trim());

		EmpleadoEntity empleadoEntity = new EmpleadoEntity();
		empleadoEntity.setIdEmpleado(idEmpleado);
		nueva.setFkEmpleadoEntity(empleadoEntity);

		CodigosTemporalesEntity codigoEntity = new CodigosTemporalesEntity();
		codigoEntity.setIdCodigo(idCodigo);
		nueva.setFkCodigoEntity(codigoEntity);

		if (ubicacionEncontrada != null) {
			UbicacionEntity ubicacionEntity = new UbicacionEntity();
			ubicacionEntity.setIdUbicacion(ubicacionEncontrada.getIdUbicacion());
			nueva.setFkUbicacionEntity(ubicacionEntity);
		}

		Marcaciones guardada = repositorio.guardar(nueva);

		if (tipo.equals("ENTRADA") || tipo.equals("SALIDA")) {
			reporteDiarioUseCase.generarOActualizar(idEmpleado, LocalDate.now());
		}

		return guardada;
	}

}
