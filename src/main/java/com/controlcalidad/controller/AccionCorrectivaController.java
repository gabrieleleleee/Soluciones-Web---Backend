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

import com.controlcalidad.dto.AccionCorrectivaDto;
import com.controlcalidad.model.AccionCorrectiva;
import com.controlcalidad.model.Inspeccion;
import com.controlcalidad.service.IAccionCorrectivaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/acciones-correctivas")
@RequiredArgsConstructor
public class AccionCorrectivaController {
	private final IAccionCorrectivaService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<AccionCorrectiva>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<AccionCorrectiva>> findById(@PathVariable("id") Integer id) throws Exception {
		AccionCorrectiva accion = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<AccionCorrectiva> model = EntityModel.of(accion,
			linkTo(methodOn(AccionCorrectivaController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(AccionCorrectivaController.class).findAll()).withRel("acciones-correctivas"));
		return ResponseEntity.ok(model);
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<AccionCorrectiva> save(@Valid @RequestBody AccionCorrectivaDto dto) throws Exception {
		AccionCorrectiva accion = new AccionCorrectiva();
		accion.setAccionTomada(dto.getAccionTomada());
		accion.setObservacion(dto.getObservacion());
		accion.setEstado(dto.isEstado());

		Inspeccion inspeccion = new Inspeccion();
		inspeccion.setIdInspeccion(dto.getIdInspeccion());
		inspeccion.setEstado(true);
		accion.setInspeccion(inspeccion);

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(accion));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<AccionCorrectiva> update(@Valid @RequestBody AccionCorrectivaDto dto,
			@PathVariable("id") Integer id) throws Exception {
		AccionCorrectiva accion = new AccionCorrectiva();
		accion.setAccionTomada(dto.getAccionTomada());
		accion.setObservacion(dto.getObservacion());
		accion.setEstado(dto.isEstado());

		Inspeccion inspeccion = new Inspeccion();
		inspeccion.setIdInspeccion(dto.getIdInspeccion());
		inspeccion.setEstado(true);
		accion.setInspeccion(inspeccion);

		return ResponseEntity.ok(service.update(accion, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
