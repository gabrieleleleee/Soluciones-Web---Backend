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

import com.controlcalidad.dto.CapacitacionPersonalDto;
import com.controlcalidad.model.CapacitacionPersonal;
import com.controlcalidad.service.ICapacitacionPersonalService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/capacitaciones")
@RequiredArgsConstructor
public class CapacitacionPersonalController {
	private final ICapacitacionPersonalService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<CapacitacionPersonal>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<CapacitacionPersonal>> findById(@PathVariable("id") Integer id) throws Exception {
		CapacitacionPersonal capacitacion = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<CapacitacionPersonal> model = EntityModel.of(capacitacion,
			linkTo(methodOn(CapacitacionPersonalController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(CapacitacionPersonalController.class).findAll()).withRel("capacitaciones"));
		return ResponseEntity.ok(model);
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<CapacitacionPersonal> save(@Valid @RequestBody CapacitacionPersonalDto dto) throws Exception {
		CapacitacionPersonal capacitacion = new CapacitacionPersonal();
		capacitacion.setTema(dto.getTema());
		capacitacion.setInstructor(dto.getInstructor());
		capacitacion.setObservaciones(dto.getObservaciones());
		capacitacion.setEstado(dto.isEstado());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(capacitacion));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<CapacitacionPersonal> update(@Valid @RequestBody CapacitacionPersonalDto dto,
			@PathVariable("id") Integer id) throws Exception {
		CapacitacionPersonal capacitacion = new CapacitacionPersonal();
		capacitacion.setTema(dto.getTema());
		capacitacion.setInstructor(dto.getInstructor());
		capacitacion.setObservaciones(dto.getObservaciones());
		capacitacion.setEstado(dto.isEstado());

		return ResponseEntity.ok(service.update(capacitacion, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
