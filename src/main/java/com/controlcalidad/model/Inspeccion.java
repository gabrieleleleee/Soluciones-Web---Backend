package com.controlcalidad.model;

import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Inspeccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idInspeccion;

	@Column(nullable = false)
	private LocalDateTime fechaHora;

	@Column(nullable = true, length = 255)
	private String observacionesGenerales;

	@Column(nullable = false)
	private boolean resultadoAprobado;

	@Column(nullable = false)
	private boolean estado;

	@ManyToOne
	@JoinColumn(name = "id_lote", nullable = false,
				foreignKey = @ForeignKey(name = "FK_INSPECCION_LOTE"))
	private Lote lote;

	@ManyToOne
	@JoinColumn(name = "id_materia_prima", nullable = false,
				foreignKey = @ForeignKey(name = "FK_INSPECCION_MATERIA_PRIMA"))
	private MateriaPrima materiaPrima;

	@OneToMany(mappedBy = "inspeccion")
	@JsonIgnore
	private List<AccionCorrectiva> accionesCorrectivas;
}
