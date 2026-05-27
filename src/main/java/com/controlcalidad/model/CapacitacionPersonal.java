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
public class CapacitacionPersonal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idCapacitacion;

	@Column(nullable = false, length = 150)
	private String tema;

	@Column(nullable = false, length = 150)
	private String instructor;

	@Column(nullable = false)
	private LocalDate fechaCapacitacion;

	@Column(nullable = true, length = 255)
	private String observaciones;

	@Column(nullable = false)
	private boolean estado;
}
