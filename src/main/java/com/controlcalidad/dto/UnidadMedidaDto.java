package com.controlcalidad.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class UnidadMedidaDto {
	@NotBlank(message = "El nombre de la unidad es obligatorio") @Size(max = 100)
	private String nombreUnidad;
	@NotBlank(message = "La abreviatura es obligatoria") @Size(max = 20)
	private String abreviatura;
	private boolean estado;
	public String getNombreUnidad() { return nombreUnidad; }
	public void setNombreUnidad(String v) { this.nombreUnidad = v; }
	public String getAbreviatura() { return abreviatura; }
	public void setAbreviatura(String v) { this.abreviatura = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
}