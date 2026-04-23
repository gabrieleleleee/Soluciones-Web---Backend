package com.controlcalidad.model;

import java.time.LocalDate;

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
public class Lote {
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLote;
	
	@ManyToOne // FK
	@JoinColumn(name = "id_producto", nullable = false, 
					foreignKey = @ForeignKey(name = "FK_LOTE_PRODUCTO"))
	private Producto producto;
	
	@Column(nullable = false, length = 50, unique = true)
	private String codigoLote;
	
	@Column(nullable = false)
	private LocalDate fechaProduccion;
	
	@Column(nullable = false)
	private Integer cantidadProducida;
	
	@Column(nullable = false, length = 30)
	private String estadoLote;
	
	@Column(nullable = true, length = 255)
	private String observaciones;
	
	@Column(nullable = false)
	private boolean estado;
}
