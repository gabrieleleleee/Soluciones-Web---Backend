package com.controlcalidad.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class PermisoDto {
	@NotBlank(message = "El codigo del permiso es obligatorio") @Size(max = 50)
	private String codigoPermiso;
	@NotBlank(message = "La descripcion es obligatoria") @Size(max = 150)
	private String descripcion;
	private boolean estado;
	public String getCodigoPermiso() { return codigoPermiso; }
	public void setCodigoPermiso(String v) { this.codigoPermiso = v; }
	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String v) { this.descripcion = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
}