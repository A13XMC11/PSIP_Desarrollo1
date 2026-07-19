package com.uisrael.asistencia.presentacion.controladores;

import com.uisrael.asistencia.aplicacion.casosuso.entrada.IEmpleadoUseCase;
import com.uisrael.asistencia.dominio.entidades.Empleado;
import com.uisrael.asistencia.infraestructura.seguridad.JwtUtil;
import com.uisrael.asistencia.infraestructura.seguridad.PasswordUtil;
import com.uisrael.asistencia.presentacion.dto.request.LoginRequestDto;
import com.uisrael.asistencia.presentacion.dto.response.LoginResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/asistencia/auth")
public class AuthController {

	private final IEmpleadoUseCase empleadoUseCase;
	private final JwtUtil jwtUtil;

	public AuthController(IEmpleadoUseCase empleadoUseCase, JwtUtil jwtUtil) {
		this.empleadoUseCase = empleadoUseCase;
		this.jwtUtil = jwtUtil;
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {
		List<Empleado> candidatos = empleadoUseCase.findByCorreoEmpleado(request.getCorreo());

		Empleado empleadoEncontrado = null;
		for (Empleado candidato : candidatos) {
			if (candidato.isEstadoEmpleado()) {
				empleadoEncontrado = candidato;
				break;
			}
		}

		if (empleadoEncontrado == null) {
			return ResponseEntity.status(401).build();
		}

		boolean contrasenaCorrecta = PasswordUtil.verificar(request.getContrasena(), empleadoEncontrado.getContrasenaEmpleado());
		if (!contrasenaCorrecta) {
			return ResponseEntity.status(401).build();
		}

		String rol = empleadoEncontrado.getFkRolEntity().getNombre(); // "ADMIN" | "SUPERVISOR" | "EMPLEADO"
		String token = jwtUtil.generarTokenSesion(empleadoEncontrado.getIdEmpleado(), rol);

		LoginResponseDto respuesta = new LoginResponseDto(token, empleadoEncontrado.getIdEmpleado(),
				empleadoEncontrado.getNombreEmpleado(), rol);
		return ResponseEntity.ok(respuesta);
	}
}