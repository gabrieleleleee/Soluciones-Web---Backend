package com.controlcalidad.model;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MaquinariaEquipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idEquipo;

	@Column(nullable = false, length = 100)
	private String nombreEquipo;

	@Column(nullable = true, length = 255)
	private String descripcion;

	@Column(nullable = false)
	private boolean estado;

	@ManyToOne
	@JoinColumn(name = "id_proveedor", nullable = false,
				foreignKey = @ForeignKey(name = "FK_MAQUINARIA_PROVEEDOR"))
	private Proveedor proveedor;

	@ManyToMany
	@JoinTable(
		name = "maquinaria_materia_prima",
		joinColumns = @JoinColumn(name = "id_maquinaria"),
		inverseJoinColumns = @JoinColumn(name = "id_materia_prima")
	)
	private List<MateriaPrima> materiasPrimas;
}
