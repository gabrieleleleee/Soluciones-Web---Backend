package com.controlcalidad.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public class AccionCorrectivaDto {
	@NotBlank(message = "La accion tomada es obligatoria") @Size(max = 255)
	private String accionTomada;
	@NotBlank(message = "La fecha de registro es obligatoria")
	private String fechaRegistro;
	@Size(max = 255)
	private String observacion;
	private boolean estado;
	@NotNull(message = "El id de la inspeccion es obligatorio")
	private Integer idInspeccion;
	public String getAccionTomada() { return accionTomada; }
	public void setAccionTomada(String v) { this.accionTomada = v; }
	public String getFechaRegistro() { return fechaRegistro; }
	public void setFechaRegistro(String v) { this.fechaRegistro = v; }
	public String getObservacion() { return observacion; }
	public void setObservacion(String v) { this.observacion = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
	public Integer getIdInspeccion() { return idInspeccion; }
	public void setIdInspeccion(Integer v) { this.idInspeccion = v; }
}