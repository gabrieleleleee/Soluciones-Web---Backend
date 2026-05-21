package com.controlcalidad.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EstandarCalidadDto {

	@NotNull(message = "El id del producto es obligatorio")
	private Integer idProducto;

	@NotBlank(message = "El nombre del parametro es obligatorio")
	@Size(max = 100, message = "El nombre del parametro no puede superar los 100 caracteres")
	private String nombreParametro;

	@NotBlank(message = "La unidad de medida es obligatoria")
	@Size(max = 30, message = "La unidad de medida no puede superar los 30 caracteres")
	private String unidadMedida;

	@NotNull(message = "El valor minimo es obligatorio")
	private Double valorMinimo;

	@NotNull(message = "El valor maximo es obligatorio")
	private Double valorMaximo;

	@Size(max = 255, message = "La descripcion no puede superar los 255 caracteres")
	private String descripcion;

	private boolean estado;

	public Integer getIdProducto() { return idProducto; }
	public void setIdProducto(Integer v) { this.idProducto = v; }
	public String getNombreParametro() { return nombreParametro; }
	public void setNombreParametro(String v) { this.nombreParametro = v; }
	public String getUnidadMedida() { return unidadMedida; }
	public void setUnidadMedida(String v) { this.unidadMedida = v; }
	public Double getValorMinimo() { return valorMinimo; }
	public void setValorMinimo(Double v) { this.valorMinimo = v; }
	public Double getValorMaximo() { return valorMaximo; }
	public void setValorMaximo(Double v) { this.valorMaximo = v; }
	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String v) { this.descripcion = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
}
