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

import com.controlcalidad.dto.DevolucionLoteDto;
import com.controlcalidad.model.DevolucionLote;
import com.controlcalidad.model.Lote;
import com.controlcalidad.service.IDevolucionLoteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/devoluciones")
@RequiredArgsConstructor
public class DevolucionLoteController {
	private final IDevolucionLoteService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<DevolucionLote>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<DevolucionLote>> findById(@PathVariable("id") Integer id) throws Exception {
		DevolucionLote devolucion = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<DevolucionLote> model = EntityModel.of(devolucion,
			linkTo(methodOn(DevolucionLoteController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(DevolucionLoteController.class).findAll()).withRel("devoluciones"));
		return ResponseEntity.ok(model);
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<DevolucionLote> save(@Valid @RequestBody DevolucionLoteDto dto) throws Exception {
		DevolucionLote devolucion = new DevolucionLote();
		devolucion.setMotivoDevolucion(dto.getMotivoDevolucion());
		devolucion.setCantidadDevuelta(dto.getCantidadDevuelta());
		devolucion.setEstado(dto.isEstado());

		Lote lote = new Lote();
		lote.setIdLote(dto.getIdLote());
		lote.setEstado(true);
		devolucion.setLote(lote);

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(devolucion));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<DevolucionLote> update(@Valid @RequestBody DevolucionLoteDto dto,
			@PathVariable("id") Integer id) throws Exception {
		DevolucionLote devolucion = new DevolucionLote();
		devolucion.setMotivoDevolucion(dto.getMotivoDevolucion());
		devolucion.setCantidadDevuelta(dto.getCantidadDevuelta());
		devolucion.setEstado(dto.isEstado());

		Lote lote = new Lote();
		lote.setIdLote(dto.getIdLote());
		lote.setEstado(true);
		devolucion.setLote(lote);

		return ResponseEntity.ok(service.update(devolucion, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
