package com.controlcalidad.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class MotivoRechazoDto {
	@NotBlank(message = "El codigo de falla es obligatorio") @Size(max = 50)
	private String codigoFalla;
	@NotBlank(message = "La descripcion es obligatoria") @Size(max = 255)
	private String descripcion;
	private boolean estado;
	public String getCodigoFalla() { return codigoFalla; }
	public void setCodigoFalla(String v) { this.codigoFalla = v; }
	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String v) { this.descripcion = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
}