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

import com.controlcalidad.dto.InspeccionDto;
import com.controlcalidad.model.Inspeccion;
import com.controlcalidad.model.Lote;
import com.controlcalidad.model.MateriaPrima;
import com.controlcalidad.service.IInspeccionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inspecciones")
@RequiredArgsConstructor
public class InspeccionController {
	private final IInspeccionService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<Inspeccion>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<Inspeccion>> findById(@PathVariable("id") Integer id) throws Exception {
		Inspeccion inspeccion = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<Inspeccion> model = EntityModel.of(inspeccion,
			linkTo(methodOn(InspeccionController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(InspeccionController.class).findAll()).withRel("inspecciones"));
		return ResponseEntity.ok(model);
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<Inspeccion> save(@Valid @RequestBody InspeccionDto dto) throws Exception {
		Inspeccion inspeccion = new Inspeccion();
		inspeccion.setObservacionesGenerales(dto.getObservacionesGenerales());
		inspeccion.setResultadoAprobado(dto.isResultadoAprobado());
		inspeccion.setEstado(dto.isEstado());

		Lote lote = new Lote();
		lote.setIdLote(dto.getIdLote());
		lote.setEstado(true);
		inspeccion.setLote(lote);

		MateriaPrima materiaprima = new MateriaPrima();
		materiaprima.setIdMateriaPrima(dto.getIdMateriaPrima());
		materiaprima.setEstado(true);
		inspeccion.setMateriaPrima(materiaprima);

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(inspeccion));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<Inspeccion> update(@Valid @RequestBody InspeccionDto dto,
			@PathVariable("id") Integer id) throws Exception {
		Inspeccion inspeccion = new Inspeccion();
		inspeccion.setObservacionesGenerales(dto.getObservacionesGenerales());
		inspeccion.setResultadoAprobado(dto.isResultadoAprobado());
		inspeccion.setEstado(dto.isEstado());

		Lote lote = new Lote();
		lote.setIdLote(dto.getIdLote());
		lote.setEstado(true);
		inspeccion.setLote(lote);

		MateriaPrima materiaprima = new MateriaPrima();
		materiaprima.setIdMateriaPrima(dto.getIdMateriaPrima());
		materiaprima.setEstado(true);
		inspeccion.setMateriaPrima(materiaprima);

		return ResponseEntity.ok(service.update(inspeccion, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
