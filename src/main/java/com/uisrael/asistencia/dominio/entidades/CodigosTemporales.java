package com.uisrael.asistencia.dominio.entidades;

import java.time.LocalDateTime;

public class CodigosTemporales {
	
	private int idCodigo;
	private int idEmpleado;
	private String codigo;
	private String tipo;
	private LocalDateTime generadoEn;
	private LocalDateTime expiraEn;
	private boolean usado;
	
	public CodigosTemporales(int idCodigo, int idEmpleado, String codigo, String tipo, LocalDateTime generadoEn,
			LocalDateTime expiraEn, boolean usado) {
		super();
		this.idCodigo = idCodigo;
		this.idEmpleado = idEmpleado;
		this.codigo = codigo;
		this.tipo = tipo;
		this.generadoEn = generadoEn;
		this.expiraEn = expiraEn;
		this.usado = usado;
	}

	public CodigosTemporales() {
		super();
	}

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
