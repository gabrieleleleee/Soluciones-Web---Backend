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

import com.controlcalidad.dto.LoteDto;
import com.controlcalidad.model.Lote;
import com.controlcalidad.model.Producto;
import com.controlcalidad.service.ILoteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lotes")
@RequiredArgsConstructor
public class LoteController {
	private final ILoteService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<Lote>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<Lote>> findById(@PathVariable("id") Integer id) throws Exception {
		Lote lote = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<Lote> model = EntityModel.of(lote,
			linkTo(methodOn(LoteController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(LoteController.class).findAll()).withRel("lotes"));
		return ResponseEntity.ok(model);
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<Lote> save(@Valid @RequestBody LoteDto dto) throws Exception {
		Lote lote = new Lote();
		lote.setCodigoLote(dto.getCodigoLote());
		lote.setFechaProduccion(dto.getFechaProduccion());
		lote.setCantidadProducida(dto.getCantidadProducida());
		lote.setEstadoLote(dto.getEstadoLote());
		lote.setObservaciones(dto.getObservaciones());
		lote.setEstado(dto.isEstado());

		Producto producto = new Producto();
		producto.setIdProducto(dto.getIdProducto());
		producto.setEstado(true);
		lote.setProducto(producto);

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(lote));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<Lote> update(@Valid @RequestBody LoteDto dto,
			@PathVariable("id") Integer id) throws Exception {
		Lote lote = new Lote();
		lote.setCodigoLote(dto.getCodigoLote());
		lote.setFechaProduccion(dto.getFechaProduccion());
		lote.setCantidadProducida(dto.getCantidadProducida());
		lote.setEstadoLote(dto.getEstadoLote());
		lote.setObservaciones(dto.getObservaciones());
		lote.setEstado(dto.isEstado());

		Producto producto = new Producto();
		producto.setIdProducto(dto.getIdProducto());
		producto.setEstado(true);
		lote.setProducto(producto);

		return ResponseEntity.ok(service.update(lote, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
