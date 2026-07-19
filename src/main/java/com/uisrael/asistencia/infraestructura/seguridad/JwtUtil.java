package com.uisrael.asistencia.infraestructura.seguridad;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
	private final SecretKey clave;

	public JwtUtil(@Value("${jwt.secret}") String secretoConfigurado) {
		this.clave = Keys.hmacShaKeyFor(secretoConfigurado.getBytes());
	}

	public String generarTokenSesion(int idEmpleado, String rol) {
		Date ahora = new Date();
		Date expiracion = new Date(ahora.getTime() + 8 * 60 * 60 * 1000);
		return Jwts.builder().claim("idEmpleado", idEmpleado).claim("rol", rol).issuedAt(ahora).expiration(expiracion)
				.signWith(clave).compact();
	}

	public String generarTokenMarcacion(int idEmpleado, String tipo, int idCodigo) {
		Date ahora = new Date();
		Date expiracion = new Date(ahora.getTime() + 10 * 60 * 1000);
		return Jwts.builder().claim("idEmpleado", idEmpleado).claim("tipo", tipo).claim("idCodigo", idCodigo)
				.issuedAt(ahora).expiration(expiracion).signWith(clave).compact();
	}

	public Claims validarToken(String token) {
		return Jwts.parser().verifyWith(clave).build().parseSignedClaims(token).getPayload();
	}
}
