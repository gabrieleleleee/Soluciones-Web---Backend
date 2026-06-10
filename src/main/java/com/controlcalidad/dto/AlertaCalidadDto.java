package com.controlcalidad.dto;
import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public class AlertaCalidadDto {
	@NotBlank(message = "El titulo es obligatorio") @Size(max = 100)
	private String titulo;
	@NotBlank(message = "El mensaje es obligatorio") @Size(max = 250)
	private String mensaje;
	@NotNull(message = "La fecha de alerta es obligatoria")
	private LocalDate fechaAlerta;
	private boolean estado;
	public String getTitulo() { return titulo; }
	public void setTitulo(String v) { this.titulo = v; }
	public String getMensaje() { return mensaje; }
	public void setMensaje(String v) { this.mensaje = v; }
	public LocalDate getFechaAlerta() { return fechaAlerta; }
	public void setFechaAlerta(LocalDate v) { this.fechaAlerta = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
}