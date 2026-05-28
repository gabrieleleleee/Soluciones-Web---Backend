package com.controlcalidad.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class AreaProduccionDto {
	@NotBlank(message = "El nombre del area es obligatorio") @Size(max = 100)
	private String nombreArea;
	@Size(max = 255)
	private String descripcion;
	private boolean estado;
	public String getNombreArea() { return nombreArea; }
	public void setNombreArea(String v) { this.nombreArea = v; }
	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String v) { this.descripcion = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
}