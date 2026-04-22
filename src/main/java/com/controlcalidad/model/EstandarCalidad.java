package com.controlcalidad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EstandarCalidad {
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEstandar;
	
	@ManyToOne // FK
	@JoinColumn(name = "id_producto", nullable = false, 
					foreignKey = @ForeignKey(name = "FK_ESTANDAR_PRODUCTO"))
	private Producto producto;
	
	@Column(nullable = false, length = 100)
	private String nombreParametro;
	
	@Column(nullable = false, length = 30)
	private String unidadMedida;
	
	@Column(nullable = false)
	private Double valorMinimo;
	
	@Column(nullable = false)
	private Double valorMaximo;
	
	@Column(nullable = true, length = 255)
	private String descripcion;
	
	@Column(nullable = false)
	private boolean estado;
}
