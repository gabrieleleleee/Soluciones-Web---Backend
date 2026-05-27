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
public class AlertaCalidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idAlerta;

	@Column(nullable = false, length = 100)
	private String titulo;

	@Column(nullable = false, length = 250)
	private String mensaje;

	@Column(nullable = false)
	private LocalDate fechaAlerta;

	@Column(nullable = false)
	private boolean estado;
}
