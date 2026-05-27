package com.controlcalidad.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class AlertaCalidadDto {
	@NotBlank(message = "El titulo es obligatorio") @Size(max = 100)
	private String titulo;
	@NotBlank(message = "El mensaje es obligatorio") @Size(max = 250)
	private String mensaje;
	@NotBlank(message = "La fecha de alerta es obligatoria")
	private String fechaAlerta;
	private boolean estado;
	public String getTitulo() { return titulo; }
	public void setTitulo(String v) { this.titulo = v; }
	public String getMensaje() { return mensaje; }
	public void setMensaje(String v) { this.mensaje = v; }
	public String getFechaAlerta() { return fechaAlerta; }
	public void setFechaAlerta(String v) { this.fechaAlerta = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
}