package com.uisrael.asistencia.presentacion.dto.response;

import java.time.LocalDateTime;

public class CodigosTemporalesResponseDto {
	
	private int idCodigo;
	private int idEmpleado;
	private String codigo;
	private String tipo;
	private LocalDateTime generadoEn;
	private LocalDateTime expiraEn;
	private boolean usado;
	
	public int getIdCodigo() {
		return idCodigo;
	}
	public void setIdCodigo(int idCodigo) {
		this.idCodigo = idCodigo;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public LocalDateTime getGeneradoEn() {
		return generadoEn;
	}
	public void setGeneradoEn(LocalDateTime generadoEn) {
		this.generadoEn = generadoEn;
	}
	public LocalDateTime getExpiraEn() {
		return expiraEn;
	}
	public void setExpiraEn(LocalDateTime expiraEn) {
		this.expiraEn = expiraEn;
	}
	public boolean isUsado() {
		return usado;
	}
	public void setUsado(boolean usado) {
		this.usado = usado;
	}
	
}
