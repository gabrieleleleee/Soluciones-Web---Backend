package com.controlcalidad.dto;
import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public class CapacitacionPersonalDto {
	@NotBlank(message = "El tema es obligatorio") @Size(max = 150)
	private String tema;
	@NotBlank(message = "El instructor es obligatorio") @Size(max = 150)
	private String instructor;
	@NotNull(message = "La fecha es obligatoria")
	private LocalDate fechaCapacitacion;
	@Size(max = 255)
	private String observaciones;
	private boolean estado;
	public String getTema() { return tema; }
	public void setTema(String v) { this.tema = v; }
	public String getInstructor() { return instructor; }
	public void setInstructor(String v) { this.instructor = v; }
	public LocalDate getFechaCapacitacion() { return fechaCapacitacion; }
	public void setFechaCapacitacion(LocalDate v) { this.fechaCapacitacion = v; }
	public String getObservaciones() { return observaciones; }
	public void setObservaciones(String v) { this.observaciones = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
}