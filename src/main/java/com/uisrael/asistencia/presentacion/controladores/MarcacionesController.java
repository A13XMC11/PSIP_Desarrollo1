package com.uisrael.asistencia.presentacion.controladores;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IMarcacionesUsaCase;
import com.uisrael.asistencia.dominio.entidades.Marcaciones;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.CodigosTemporalesEntity;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.EmpleadoEntity;
import com.uisrael.asistencia.infraestructura.persistencia.jpa.UbicacionEntity;
import com.uisrael.asistencia.presentacion.dto.request.MarcacionesRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.MarcacionesResponseDto;
import com.uisrael.asistencia.presentacion.mapeadores.IMarcacionesDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asistencia/marcaciones")
public class MarcacionesController {

	private final IMarcacionesUsaCase marcacionesUseCase;
	private final IMarcacionesDtoMapper mapper;

	public MarcacionesController(IMarcacionesUsaCase marcacionesUseCase, IMarcacionesDtoMapper mapper) {
		super();
		this.marcacionesUseCase = marcacionesUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MarcacionesResponseDto guardar(@Valid @RequestBody MarcacionesRequestDto requestMarcaciones) {
		Marcaciones marcaciones = mapper.toDomain(requestMarcaciones);

		EmpleadoEntity empleado = new EmpleadoEntity();
		empleado.setIdEmpleado(requestMarcaciones.getIdEmpleado());
		marcaciones.setFkEmpleadoEntity(empleado);

		CodigosTemporalesEntity codigo = new CodigosTemporalesEntity();
		codigo.setIdCodigo(requestMarcaciones.getIdCodigo());
		marcaciones.setFkCodigoEntity(codigo);

		UbicacionEntity ubicacion = new UbicacionEntity();
		ubicacion.setIdUbicacion(requestMarcaciones.getIdUbicacion());
		marcaciones.setFkUbicacionEntity(ubicacion);

		return mapper.toResponseDto(marcacionesUseCase.guardar(marcaciones));
	}

	@GetMapping
	public List<MarcacionesResponseDto> listarTodos() {
		return marcacionesUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@DeleteMapping("/{idMarcaciones}")
	public ResponseEntity<Void> eliminar(@PathVariable int idMarcaciones) {
		marcacionesUseCase.eliminar(idMarcaciones);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/empleado/{idEmpleado}")
	public List<MarcacionesResponseDto> buscarPorEmpleado(@PathVariable int idEmpleado) {
		return marcacionesUseCase.buscarPorEmpleado(idEmpleado).stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/empleado/{idEmpleado}/fecha/{fecha}")
	public List<MarcacionesResponseDto> buscarPorEmpleadoYFecha(@PathVariable int idEmpleado,
			@PathVariable LocalDate fecha) {
		return marcacionesUseCase.buscarPorEmpleadoYFecha(idEmpleado, fecha).stream().map(mapper::toResponseDto)
				.toList();
	}

	@GetMapping("/tipo/{tipo}")
	public List<MarcacionesResponseDto> buscarPorTipo(@PathVariable String tipo) {
		return marcacionesUseCase.buscarPorTipo(tipo).stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/validas")
	public List<MarcacionesResponseDto> listarValidas() {
		return marcacionesUseCase.listarMarcacionesValidas().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/correctas")
	public List<MarcacionesResponseDto> listarCorrectas() {
		return marcacionesUseCase.listarMarcacionesCorrectas().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/ubicacion/{idUbicacion}")
	public List<MarcacionesResponseDto> buscarPorUbicacion(@PathVariable int idUbicacion) {
		return marcacionesUseCase.buscarPorUbicacion(idUbicacion).stream().map(mapper::toResponseDto).toList();
	}

}
