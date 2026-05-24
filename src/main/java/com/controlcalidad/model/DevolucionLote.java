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
public class DevolucionLote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idDevolucion;

	@ManyToOne
	@JoinColumn(name = "id_lote", nullable = false,
				foreignKey = @ForeignKey(name = "FK_DEVOLUCION_LOTE"))
	private Lote lote;

	@Column(nullable = false)
	private LocalDate fechaDevolucion;

	@Column(nullable = false, length = 255)
	private String motivoDevolucion;

	@Column(nullable = false)
	private Integer cantidadDevuelta;

	@Column(nullable = false)
	private boolean estado;
}
