package com.controlcalidad.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public class MaquinariaEquipoDto {
	@NotBlank(message = "El nombre del equipo es obligatorio") @Size(max = 100)
	private String nombreEquipo;
	@Size(max = 255)
	private String descripcion;
	private boolean estado;
	@NotNull(message = "El id del proveedor es obligatorio")
	private Integer idProveedor;
	public String getNombreEquipo() { return nombreEquipo; }
	public void setNombreEquipo(String v) { this.nombreEquipo = v; }
	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String v) { this.descripcion = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
	public Integer getIdProveedor() { return idProveedor; }
	public void setIdProveedor(Integer v) { this.idProveedor = v; }
}