package com.controlcalidad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name="roles")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idRol;
	
	@Column(nullable = false, length = 50, unique = true)
	private String nombre;
	
	@Column(nullable = true, length = 200)
	private String descripcion;
	
	@Column(nullable = false)
	private boolean estado;
}
