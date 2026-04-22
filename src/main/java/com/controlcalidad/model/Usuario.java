package com.controlcalidad.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idUsuario;
	
	@Column(nullable = false, length = 70, unique = true)
	private String nombreUsuario;
	
	@Column(nullable = false, length = 100)
	private String contrasena;
	
	@Column(nullable = false, length = 100)
	private String nombreCompleto;
	
	@Column(nullable = false, length = 100, unique = true)
	private String correo;
	
	@Column(nullable = false)
	private boolean activo;
	
	@ManyToMany(fetch = FetchType.EAGER) //Relacion muchos a muchos
	@JoinTable(name = "usuario_rol",
			joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"),
			inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
	private List<Rol> roles;
}
