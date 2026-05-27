package com.controlcalidad.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public class InspeccionDto {
	@NotBlank(message = "La fecha y hora son obligatorias")
	private String fechaHora;
	@Size(max = 255)
	private String observacionesGenerales;
	private boolean resultadoAprobado;
	private boolean estado;
	@NotNull(message = "El id del lote es obligatorio")
	private Integer idLote;
	@NotNull(message = "El id de la materia prima es obligatorio")
	private Integer idMateriaPrima;
	public String getFechaHora() { return fechaHora; }
	public void setFechaHora(String v) { this.fechaHora = v; }
	public String getObservacionesGenerales() { return observacionesGenerales; }
	public void setObservacionesGenerales(String v) { this.observacionesGenerales = v; }
	public boolean isResultadoAprobado() { return resultadoAprobado; }
	public void setResultadoAprobado(boolean v) { this.resultadoAprobado = v; }
	public boolean isEstado() { return estado; }
	public void setEstado(boolean v) { this.estado = v; }
	public Integer getIdLote() { return idLote; }
	public void setIdLote(Integer v) { this.idLote = v; }
	public Integer getIdMateriaPrima() { return idMateriaPrima; }
	public void setIdMateriaPrima(Integer v) { this.idMateriaPrima = v; }
}