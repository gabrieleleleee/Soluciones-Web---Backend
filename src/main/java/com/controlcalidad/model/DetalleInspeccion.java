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
public class DetalleInspeccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idDetalle;

	@Column(nullable = false)
	private Double valorMedido;

	@Column(nullable = false)
	private boolean cumpleEstandar;

	@ManyToOne
	@JoinColumn(name = "id_inspeccion", nullable = false,
				foreignKey = @ForeignKey(name = "FK_DETALLE_INSPECCION"))
	private Inspeccion inspeccion;

	@ManyToOne
	@JoinColumn(name = "id_estandar", nullable = false,
				foreignKey = @ForeignKey(name = "FK_DETALLE_ESTANDAR"))
	private EstandarCalidad estandarCalidad;
}
