package com.controlcalidad.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public class MateriaPrimaDto {
	@NotBlank(message = "El nombre es obligatorio") @Size(max = 100)
	private String nombre;
	@Size(max = 255)
	private String descripcion;
	@NotNull(message = "El stock es obligatorio") @Min(value = 0)
	private Integer stock;
	private boolean estado;
	public String getNombre() { return nombre; }
	public void setNombre(String v) { this.nombre = v; }
	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String v) { this.descripcion = v; }
	public Integer getStock() { return stock; }
	public void setStock(Integer v) { this.stock = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
}