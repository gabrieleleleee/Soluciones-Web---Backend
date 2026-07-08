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

import com.controlcalidad.dto.AreaProduccionDto;
import com.controlcalidad.model.AreaProduccion;
import com.controlcalidad.service.IAreaProduccionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/areas-produccion")
@RequiredArgsConstructor
public class AreaProduccionController {
	private final IAreaProduccionService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<AreaProduccion>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<AreaProduccion>> findAllPageable(@PageableDefault(size = 10, direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable pageable) throws Exception {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<AreaProduccion>> findById(@PathVariable("id") Integer id) throws Exception {
		AreaProduccion area = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<AreaProduccion> model = EntityModel.of(area,
			linkTo(methodOn(AreaProduccionController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(AreaProduccionController.class).findAll()).withRel("areas-produccion"));
		return ResponseEntity.ok(model);
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<AreaProduccion> save(@Valid @RequestBody AreaProduccionDto dto) throws Exception {
		AreaProduccion area = new AreaProduccion();
		area.setNombreArea(dto.getNombreArea());
		area.setDescripcion(dto.getDescripcion());
		area.setEstado(dto.isEstado());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(area));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<AreaProduccion> update(@Valid @RequestBody AreaProduccionDto dto,
			@PathVariable("id") Integer id) throws Exception {
		AreaProduccion area = new AreaProduccion();
		area.setNombreArea(dto.getNombreArea());
		area.setDescripcion(dto.getDescripcion());
		area.setEstado(dto.isEstado());

		return ResponseEntity.ok(service.update(area, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
