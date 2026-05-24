package com.controlcalidad.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MateriaPrima {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idMateriaPrima;

	@Column(nullable = false, length = 100)
	private String nombre;

	@Column(nullable = true, length = 255)
	private String descripcion;

	@Column(nullable = false)
	private Integer stock;

	@Column(nullable = false)
	private boolean estado;

	@ManyToMany(mappedBy = "materiasPrimas")
	@JsonIgnore
	private List<MaquinariaEquipo> maquinarias;

	@OneToMany(mappedBy = "materiaPrima")
	@JsonIgnore
	private List<Inspeccion> inspecciones;
}
