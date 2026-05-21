package com.controlcalidad.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RolDto {

	@NotBlank(message = "El nombre es obligatorio")
	@Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
	private String nombre;

	@Size(max = 200, message = "La descripcion no puede superar los 200 caracteres")
	private String descripcion;

	private boolean estado;

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean estado) { this.estado = estado; }
}
