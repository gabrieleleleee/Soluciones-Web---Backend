package com.controlcalidad.dto;
import java.time.LocalDate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class DevolucionLoteDto {
	@NotNull(message = "El id del lote es obligatorio")
	private Integer idLote;
	@NotNull(message = "La fecha de devolucion es obligatoria")
	private LocalDate fechaDevolucion;
	@NotBlank(message = "El motivo es obligatorio") @Size(max = 255)
	private String motivoDevolucion;
	@NotNull(message = "La cantidad devuelta es obligatoria") @Min(value = 1)
	private Integer cantidadDevuelta;
	private boolean estado;
	public Integer getIdLote() { return idLote; }
	public void setIdLote(Integer v) { this.idLote = v; }
	public LocalDate getFechaDevolucion() { return fechaDevolucion; }
	public void setFechaDevolucion(LocalDate v) { this.fechaDevolucion = v; }
	public String getMotivoDevolucion() { return motivoDevolucion; }
	public void setMotivoDevolucion(String v) { this.motivoDevolucion = v; }
	public Integer getCantidadDevuelta() { return cantidadDevuelta; }
	public void setCantidadDevuelta(Integer v) { this.cantidadDevuelta = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
}