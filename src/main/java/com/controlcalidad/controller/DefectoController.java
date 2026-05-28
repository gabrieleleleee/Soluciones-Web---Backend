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

import com.controlcalidad.dto.DefectoDto;
import com.controlcalidad.model.Defecto;
import com.controlcalidad.service.IDefectoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/defectos")
@RequiredArgsConstructor
public class DefectoController {
	private final IDefectoService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<Defecto>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<Defecto>> findById(@PathVariable("id") Integer id) throws Exception {
		Defecto defecto = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<Defecto> model = EntityModel.of(defecto,
			linkTo(methodOn(DefectoController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(DefectoController.class).findAll()).withRel("defectos"));
		return ResponseEntity.ok(model);
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<Defecto> save(@Valid @RequestBody DefectoDto dto) throws Exception {
		Defecto defecto = new Defecto();
		defecto.setTipoDefecto(dto.getTipoDefecto());
		defecto.setDescripcion(dto.getDescripcion());
		defecto.setEstado(dto.isEstado());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(defecto));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<Defecto> update(@Valid @RequestBody DefectoDto dto,
			@PathVariable("id") Integer id) throws Exception {
		Defecto defecto = new Defecto();
		defecto.setTipoDefecto(dto.getTipoDefecto());
		defecto.setDescripcion(dto.getDescripcion());
		defecto.setEstado(dto.isEstado());

		return ResponseEntity.ok(service.update(defecto, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
