package com.controlcalidad.model;

import java.time.LocalDateTime;

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
public class BitacoraAuditoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idBitacora;

	@Column(nullable = false, length = 100)
	private String accion;

	@Column(nullable = false, length = 100)
	private String tabla;

	@Column(nullable = false, length = 150)
	private String usuarioResponsable;

	@Column(nullable = false)
	private LocalDateTime fechaHora;

	@Column(nullable = true, length = 255)
	private String descripcion;
}
