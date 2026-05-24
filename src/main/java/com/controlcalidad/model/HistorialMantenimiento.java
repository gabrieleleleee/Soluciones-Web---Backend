package com.controlcalidad.model;

import java.time.LocalDateTime;
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
public class HistorialMantenimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idMantenimiento;

	@ManyToOne
	@JoinColumn(name = "id_equipo", nullable = false,
				foreignKey = @ForeignKey(name = "FK_HISTORIAL_MAQUINARIA"))
	private MaquinariaEquipo maquinariaEquipo;

	@Column(nullable = false)
	private LocalDateTime fechaMantenimiento;

	@Column(nullable = false, length = 50)
	private String tipoMantenimiento;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String descripcionActividad;

	@Column(nullable = false, length = 100)
	private String tecnicoResponsable;

	@Column(nullable = false)
	private Double costo;

	@Column(nullable = false)
	private boolean estado;
}
