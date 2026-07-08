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

import com.controlcalidad.dto.RolDto;
import com.controlcalidad.model.Rol;
import com.controlcalidad.service.IRolService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RolController {
	private final IRolService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<Rol>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<Rol>> findById(@PathVariable("id") Integer id) throws Exception {
		Rol rol = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<Rol> model = EntityModel.of(rol,
			linkTo(methodOn(RolController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(RolController.class).findAll()).withRel("roles"));
		return ResponseEntity.ok(model);
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<Rol>> findAllPageable(@PageableDefault(size = 10, sort = "id", direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable pageable) throws Exception {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<Rol> save(@Valid @RequestBody RolDto dto) throws Exception {
		Rol rol = new Rol();
		rol.setNombre(dto.getNombre());
		rol.setDescripcion(dto.getDescripcion());
		rol.setEstado(dto.isEstado());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(rol));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<Rol> update(@Valid @RequestBody RolDto dto,
			@PathVariable("id") Integer id) throws Exception {
		Rol rol = new Rol();
		rol.setNombre(dto.getNombre());
		rol.setDescripcion(dto.getDescripcion());
		rol.setEstado(dto.isEstado());

		return ResponseEntity.ok(service.update(rol, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
