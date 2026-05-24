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
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idProveedor;

	@Column(nullable = false, length = 150)
	private String razonSocial;

	@Column(nullable = false, unique = true, length = 11)
	private String ruc;

	@Column(nullable = true, length = 20)
	private String telefono;

	@Column(nullable = true, length = 150)
	private String direccion;

	@Column(nullable = false)
	private boolean estado;

	@OneToMany(mappedBy = "proveedor")
	@JsonIgnore
	private List<MaquinariaEquipo> maquinarias;
}
