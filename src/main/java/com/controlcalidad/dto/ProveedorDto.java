package com.controlcalidad.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class ProveedorDto {
	@NotBlank(message = "La razon social es obligatoria") @Size(max = 150)
	private String razonSocial;
	@NotBlank(message = "El RUC es obligatorio") @Size(min = 11, max = 11, message = "El RUC debe tener 11 digitos")
	private String ruc;
	@Size(max = 20)
	private String telefono;
	@Size(max = 150)
	private String direccion;
	private boolean estado;
	public String getRazonSocial() { return razonSocial; }
	public void setRazonSocial(String v) { this.razonSocial = v; }
	public String getRuc() { return ruc; }
	public void setRuc(String v) { this.ruc = v; }
	public String getTelefono() { return telefono; }
	public void setTelefono(String v) { this.telefono = v; }
	public String getDireccion() { return direccion; }
	public void setDireccion(String v) { this.direccion = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
}