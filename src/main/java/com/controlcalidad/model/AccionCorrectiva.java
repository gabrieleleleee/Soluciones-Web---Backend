package com.controlcalidad.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AccionCorrectiva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idAccion;

	@Column(nullable = false, length = 255)
	private String accionTomada;

	@Column(nullable = false)
	private LocalDateTime fechaRegistro;

	@Column(nullable = true, length = 255)
	private String observacion;

	@Column(nullable = false)
	private boolean estado;

	@ManyToOne
	@JoinColumn(name = "id_inspeccion", nullable = false,
				foreignKey = @ForeignKey(name = "FK_ACCION_INSPECCION"))
	private Inspeccion inspeccion;
}
