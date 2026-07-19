package com.uisrael.asistencia.infraestructura.seguridad;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

	public static String hash(String contrasenaPlano) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hashBytes = digest.digest(contrasenaPlano.getBytes());

			StringBuilder resultado = new StringBuilder();
			for (int i = 0; i < hashBytes.length; i++) {
				String hex = Integer.toHexString(0xff & hashBytes[i]);
				if (hex.length() == 1) {
					resultado.append("0");
				}
				resultado.append(hex);
			}
			return resultado.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error generando hash de contraseña", e);
		}
	}

	public static boolean verificar(String contrasenaPlano, String hashGuardado) {
		String hashCalculado = hash(contrasenaPlano);
		return hashCalculado.equals(hashGuardado);
	}
}
