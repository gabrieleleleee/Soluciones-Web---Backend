package com.controlcalidad.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoteDto {

	@NotNull(message = "El id del producto es obligatorio")
	private Integer idProducto;

	@NotBlank(message = "El codigo del lote es obligatorio")
	@Size(max = 50, message = "El codigo del lote no puede superar los 50 caracteres")
	private String codigoLote;

	@NotNull(message = "La fecha de produccion es obligatoria")
	private LocalDate fechaProduccion;

	@NotNull(message = "La cantidad producida es obligatoria")
	@Min(value = 1, message = "La cantidad producida debe ser mayor a 0")
	private Integer cantidadProducida;

	@NotBlank(message = "El estado del lote es obligatorio")
	@Size(max = 30, message = "El estado del lote no puede superar los 30 caracteres")
	private String estadoLote;

	@Size(max = 255, message = "Las observaciones no pueden superar los 255 caracteres")
	private String observaciones;

	private boolean estado;

	public Integer getIdProducto() { return idProducto; }
	public void setIdProducto(Integer v) { this.idProducto = v; }
	public String getCodigoLote() { return codigoLote; }
	public void setCodigoLote(String v) { this.codigoLote = v; }
	public LocalDate getFechaProduccion() { return fechaProduccion; }
	public void setFechaProduccion(LocalDate v) { this.fechaProduccion = v; }
	public Integer getCantidadProducida() { return cantidadProducida; }
	public void setCantidadProducida(Integer v) { this.cantidadProducida = v; }
	public String getEstadoLote() { return estadoLote; }
	public void setEstadoLote(String v) { this.estadoLote = v; }
	public String getObservaciones() { return observaciones; }
	public void setObservaciones(String v) { this.observaciones = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
}
