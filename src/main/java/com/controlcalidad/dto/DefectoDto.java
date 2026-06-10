package com.controlcalidad.dto;
import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public class DefectoDto {
	@NotBlank(message = "El tipo de defecto es obligatorio") @Size(max = 100)
	private String tipoDefecto;
	@NotBlank(message = "La descripcion es obligatoria") @Size(max = 200)
	private String descripcion;
	@NotNull(message = "La fecha de registro es obligatoria")
	private LocalDate fechaRegistro;
	private boolean estado;
	public String getTipoDefecto() { return tipoDefecto; }
	public void setTipoDefecto(String v) { this.tipoDefecto = v; }
	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String v) { this.descripcion = v; }
	public LocalDate getFechaRegistro() { return fechaRegistro; }
	public void setFechaRegistro(LocalDate v) { this.fechaRegistro = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
}