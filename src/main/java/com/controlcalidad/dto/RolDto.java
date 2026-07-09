package com.controlcalidad.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class RolDto {
	@NotBlank(message = "El nombre es obligatorio")
	@Size(max = 50, message = "Max 50 caracteres")
	private String nombre;
	@Size(max = 200, message = "Max 200 caracteres")
	private String descripcion;
	@Size(max = 50, message = "Max 50 caracteres")
	private String modulo;
	private boolean estado;
	public String getNombre() { return nombre; }
	public void setNombre(String v) { this.nombre = v; }
	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String v) { this.descripcion = v; }
	public String getModulo() { return modulo; }
	public void setModulo(String v) { this.modulo = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
}