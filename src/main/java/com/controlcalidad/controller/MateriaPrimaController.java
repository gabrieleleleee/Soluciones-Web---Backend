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

import com.controlcalidad.dto.MateriaPrimaDto;
import com.controlcalidad.model.MateriaPrima;
import com.controlcalidad.service.IMateriaPrimaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/materias-primas")
@RequiredArgsConstructor
public class MateriaPrimaController {
	private final IMateriaPrimaService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<MateriaPrima>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<MateriaPrima>> findById(@PathVariable("id") Integer id) throws Exception {
		MateriaPrima materiaPrima = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<MateriaPrima> model = EntityModel.of(materiaPrima,
			linkTo(methodOn(MateriaPrimaController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(MateriaPrimaController.class).findAll()).withRel("materias-primas"));
		return ResponseEntity.ok(model);
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<MateriaPrima> save(@Valid @RequestBody MateriaPrimaDto dto) throws Exception {
		MateriaPrima materiaPrima = new MateriaPrima();
		materiaPrima.setNombre(dto.getNombre());
		materiaPrima.setDescripcion(dto.getDescripcion());
		materiaPrima.setStock(dto.getStock());
		materiaPrima.setEstado(dto.isEstado());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(materiaPrima));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<MateriaPrima> update(@Valid @RequestBody MateriaPrimaDto dto,
			@PathVariable("id") Integer id) throws Exception {
		MateriaPrima materiaPrima = new MateriaPrima();
		materiaPrima.setNombre(dto.getNombre());
		materiaPrima.setDescripcion(dto.getDescripcion());
		materiaPrima.setStock(dto.getStock());
		materiaPrima.setEstado(dto.isEstado());

		return ResponseEntity.ok(service.update(materiaPrima, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
