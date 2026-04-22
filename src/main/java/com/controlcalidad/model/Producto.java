package com.controlcalidad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name="productos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idProducto;
	
	@Column(nullable = false, length = 50, unique = true)
	private String codigo;
	
	@Column(nullable = false, length = 100)
	private String nombre;
	
	@Column(nullable = true, length = 255)
	private String descripcion;
	
	@Column(nullable = false, length = 50)
	private String unidadMedida;
	
	@Column(nullable = false)
	private Double precioUnitario;
	
	@Column(nullable = false)
	private boolean estado;
}
