package com.controlcalidad.model;

import java.time.LocalDate;
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Defecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idDefecto;

	@Column(nullable = false, length = 100)
	private String tipoDefecto;

	@Column(nullable = false, length = 200)
	private String descripcion;

	@Column(nullable = false)
	private LocalDate fechaRegistro;

	@Column(nullable = false)
	private boolean estado;
}
