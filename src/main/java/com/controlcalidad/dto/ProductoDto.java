package com.controlcalidad.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductoDto {

	@NotBlank(message = "El codigo es obligatorio")
	@Size(max = 50, message = "El codigo no puede superar los 50 caracteres")
	private String codigo;

	@NotBlank(message = "El nombre es obligatorio")
	@Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
	private String nombre;

	@Size(max = 255, message = "La descripcion no puede superar los 255 caracteres")
	private String descripcion;

	@NotBlank(message = "La unidad de medida es obligatoria")
	@Size(max = 50, message = "La unidad de medida no puede superar los 50 caracteres")
	private String unidadMedida;

	@NotNull(message = "El precio unitario es obligatorio")
	@Min(value = 0, message = "El precio unitario no puede ser negativo")
	private Double precioUnitario;

	private boolean estado;

	public String getCodigo() { return codigo; }
	public void setCodigo(String v) { this.codigo = v; }
	public String getNombre() { return nombre; }
	public void setNombre(String v) { this.nombre = v; }
	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String v) { this.descripcion = v; }
	public String getUnidadMedida() { return unidadMedida; }
	public void setUnidadMedida(String v) { this.unidadMedida = v; }
	public Double getPrecioUnitario() { return precioUnitario; }
	public void setPrecioUnitario(Double v) { this.precioUnitario = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
}
