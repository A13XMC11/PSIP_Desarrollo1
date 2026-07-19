package com.uisrael.asistencia.infraestructura.correo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

public class EmailService {
	
	private final JavaMailSender mailSender;

	@Value("${app.frontend.url}")
	private String frontendUrl;

	public EmailService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void enviarLinkMarcacion(String correoDestino, String tipo, String token) {
		String link = frontendUrl + "/asistencia/registrar?token=" + token;

		SimpleMailMessage mensaje = new SimpleMailMessage();
		mensaje.setTo(correoDestino);
		mensaje.setSubject("Registrar " + tipo);
		mensaje.setText("Presiona el siguiente link para registrar tu " + tipo + " (válido por 10 minutos):\n\n" + link);
		mailSender.send(mensaje);
	}
}
