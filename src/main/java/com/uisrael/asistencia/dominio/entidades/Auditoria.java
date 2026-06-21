package com.uisrael.asistencia.dominio.entidades;

import java.time.LocalDateTime;

public class Auditoria {

		private long idAuditoria;
		private int idEmpleado;
		private String accion;
		private String tablaAfectada;
		private int registroId;
		private String detalle;
		private String ip;
		private LocalDateTime fechaHora;
		
		
		public Auditoria(long idAuditoria, int idEmpleado, String accion, String tablaAfectada, int registroId,
				String detalle, String ip, LocalDateTime fechaHora) {
			super();
			this.idAuditoria = idAuditoria;
			this.idEmpleado = idEmpleado;
			this.accion = accion;
			this.tablaAfectada = tablaAfectada;
			this.registroId = registroId;
			this.detalle = detalle;
			this.ip = ip;
			this.fechaHora = fechaHora;
		}


		public Auditoria() {
			super();
		}


		public long getIdAuditoria() {
			return idAuditoria;
		}


		public void setIdAuditoria(long idAuditoria) {
			this.idAuditoria = idAuditoria;
		}


		public int getIdEmpleado() {
			return idEmpleado;
		}


		public void setIdEmpleado(int idEmpleado) {
			this.idEmpleado = idEmpleado;
		}


		public String getAccion() {
			return accion;
		}


		public void setAccion(String accion) {
			this.accion = accion;
		}


		public String getTablaAfectada() {
			return tablaAfectada;
		}


		public void setTablaAfectada(String tablaAfectada) {
			this.tablaAfectada = tablaAfectada;
		}


		public int getRegistroId() {
			return registroId;
		}


		public void setRegistroId(int registroId) {
			this.registroId = registroId;
		}


		public String getDetalle() {
			return detalle;
		}


		public void setDetalle(String detalle) {
			this.detalle = detalle;
		}


		public String getIp() {
			return ip;
		}


		public void setIp(String ip) {
			this.ip = ip;
		}


		public LocalDateTime getFechaHora() {
			return fechaHora;
		}


		public void setFechaHora(LocalDateTime fechaHora) {
			this.fechaHora = fechaHora;
		}
		
		
	
}
