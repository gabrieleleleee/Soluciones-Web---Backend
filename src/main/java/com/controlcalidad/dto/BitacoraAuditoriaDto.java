package com.controlcalidad.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class BitacoraAuditoriaDto {
	@NotBlank(message = "La accion es obligatoria") @Size(max = 100)
	private String accion;
	@NotBlank(message = "La tabla es obligatoria") @Size(max = 100)
	private String tabla;
	@NotBlank(message = "El usuario responsable es obligatorio") @Size(max = 150)
	private String usuarioResponsable;
	@Size(max = 255)
	private String descripcion;
	public String getAccion() { return accion; }
	public void setAccion(String v) { this.accion = v; }
	public String getTabla() { return tabla; }
	public void setTabla(String v) { this.tabla = v; }
	public String getUsuarioResponsable() { return usuarioResponsable; }
	public void setUsuarioResponsable(String v) { this.usuarioResponsable = v; }
	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String v) { this.descripcion = v; }
}