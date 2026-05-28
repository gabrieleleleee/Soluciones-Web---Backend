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

import com.controlcalidad.dto.PermisoDto;
import com.controlcalidad.model.Permiso;
import com.controlcalidad.service.IPermisoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/permisos")
@RequiredArgsConstructor
public class PermisoController {
	private final IPermisoService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<Permiso>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<Permiso>> findById(@PathVariable("id") Integer id) throws Exception {
		Permiso permiso = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<Permiso> model = EntityModel.of(permiso,
			linkTo(methodOn(PermisoController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(PermisoController.class).findAll()).withRel("permisos"));
		return ResponseEntity.ok(model);
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<Permiso> save(@Valid @RequestBody PermisoDto dto) throws Exception {
		Permiso permiso = new Permiso();
		permiso.setCodigoPermiso(dto.getCodigoPermiso());
		permiso.setDescripcion(dto.getDescripcion());
		permiso.setEstado(dto.isEstado());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(permiso));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<Permiso> update(@Valid @RequestBody PermisoDto dto,
			@PathVariable("id") Integer id) throws Exception {
		Permiso permiso = new Permiso();
		permiso.setCodigoPermiso(dto.getCodigoPermiso());
		permiso.setDescripcion(dto.getDescripcion());
		permiso.setEstado(dto.isEstado());

		return ResponseEntity.ok(service.update(permiso, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
