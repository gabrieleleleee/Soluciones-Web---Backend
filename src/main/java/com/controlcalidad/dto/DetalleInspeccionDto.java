package com.controlcalidad.dto;
import jakarta.validation.constraints.NotNull;
public class DetalleInspeccionDto {
	@NotNull(message = "El valor medido es obligatorio")
	private Double valorMedido;
	private boolean cumpleEstandar;
	@NotNull(message = "El id de la inspeccion es obligatorio")
	private Integer idInspeccion;
	@NotNull(message = "El id del estandar es obligatorio")
	private Integer idEstandar;
	public Double getValorMedido() { return valorMedido; }
	public void setValorMedido(Double v) { this.valorMedido = v; }
	public boolean isCumpleEstandar() { return cumpleEstandar; }
	public void setCumpleEstandar(boolean v) { this.cumpleEstandar = v; }
	public Integer getIdInspeccion() { return idInspeccion; }
	public void setIdInspeccion(Integer v) { this.idInspeccion = v; }
	public Integer getIdEstandar() { return idEstandar; }
	public void setIdEstandar(Integer v) { this.idEstandar = v; }
}