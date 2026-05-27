package com.controlcalidad.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class CategoriaProductoDto {
	@NotBlank(message = "El nombre es obligatorio") @Size(max = 100)
	private String nombre;
	@Size(max = 255)
	private String descripcion;
	private boolean estado;
	public String getNombre() { return nombre; }
	public void setNombre(String v) { this.nombre = v; }
	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String v) { this.descripcion = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
}