package com.controlcalidad.dto;
import java.time.LocalDateTime;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public class HistorialMantenimientoDto {
	@NotNull(message = "El id del equipo es obligatorio")
	private Integer idEquipo;
	@NotNull(message = "La fecha es obligatoria")
	private LocalDateTime fechaMantenimiento;
	@NotBlank(message = "El tipo de mantenimiento es obligatorio") @Size(max = 50)
	private String tipoMantenimiento;
	@NotBlank(message = "La descripcion es obligatoria")
	private String descripcionActividad;
	@NotBlank(message = "El tecnico responsable es obligatorio") @Size(max = 100)
	private String tecnicoResponsable;
	@NotNull(message = "El costo es obligatorio") @Min(value = 0)
	private Double costo;
	private boolean estado;
	public Integer getIdEquipo() { return idEquipo; }
	public void setIdEquipo(Integer v) { this.idEquipo = v; }
	public LocalDateTime getFechaMantenimiento() { return fechaMantenimiento; }
	public void setFechaMantenimiento(LocalDateTime v) { this.fechaMantenimiento = v; }
	public String getTipoMantenimiento() { return tipoMantenimiento; }
	public void setTipoMantenimiento(String v) { this.tipoMantenimiento = v; }
	public String getDescripcionActividad() { return descripcionActividad; }
	public void setDescripcionActividad(String v) { this.descripcionActividad = v; }
	public String getTecnicoResponsable() { return tecnicoResponsable; }
	public void setTecnicoResponsable(String v) { this.tecnicoResponsable = v; }
	public Double getCosto() { return costo; }
	public void setCosto(Double v) { this.costo = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
}