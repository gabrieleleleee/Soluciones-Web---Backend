package com.controlcalidad.controller;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import com.controlcalidad.dto.UsuarioDto;
import com.controlcalidad.model.Usuario;
import com.controlcalidad.service.IUsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
	private final IUsuarioService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<Usuario>> findAllPageable(@PageableDefault(size = 10, direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable pageable) throws Exception {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<Usuario>> findById(@PathVariable("id") Integer id) throws Exception {
		Usuario usuario = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<Usuario> model = EntityModel.of(usuario,
			linkTo(methodOn(UsuarioController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(UsuarioController.class).findAll()).withRel("usuarios"));
		return ResponseEntity.ok(model);
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<Usuario> save(@Valid @RequestBody UsuarioDto dto) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setNombreUsuario(dto.getNombreUsuario());
		usuario.setContrasena(dto.getContrasena());
		usuario.setNombreCompleto(dto.getNombreCompleto());
		usuario.setCorreo(dto.getCorreo());
		usuario.setActivo(dto.isActivo());

		if (dto.getIdsRoles() != null) {
			java.util.List<com.controlcalidad.model.Rol> roles = dto.getIdsRoles().stream()
				.map(id -> { com.controlcalidad.model.Rol r = new com.controlcalidad.model.Rol(); r.setIdRol(id); r.setEstado(true); return r; })
				.toList();
			usuario.setRoles(roles);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuario));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> update(@Valid @RequestBody UsuarioDto dto,
			@PathVariable("id") Integer id) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setNombreUsuario(dto.getNombreUsuario());
		usuario.setContrasena(dto.getContrasena());
		usuario.setNombreCompleto(dto.getNombreCompleto());
		usuario.setCorreo(dto.getCorreo());
		usuario.setActivo(dto.isActivo());

		if (dto.getIdsRoles() != null) {
			java.util.List<com.controlcalidad.model.Rol> roles = dto.getIdsRoles().stream()
				.map(rolId -> { com.controlcalidad.model.Rol r = new com.controlcalidad.model.Rol(); r.setIdRol(rolId); r.setEstado(true); return r; })
				.toList();
			usuario.setRoles(roles);
		}

		return ResponseEntity.ok(service.update(usuario, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
