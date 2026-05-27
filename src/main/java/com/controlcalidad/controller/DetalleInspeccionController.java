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

import com.controlcalidad.dto.DetalleInspeccionDto;
import com.controlcalidad.model.DetalleInspeccion;
import com.controlcalidad.model.Inspeccion;
import com.controlcalidad.model.EstandarCalidad;
import com.controlcalidad.service.IDetalleInspeccionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/detalles-inspeccion")
@RequiredArgsConstructor
public class DetalleInspeccionController {
	private final IDetalleInspeccionService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<DetalleInspeccion>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<DetalleInspeccion>> findById(@PathVariable("id") Integer id) throws Exception {
		DetalleInspeccion detalle = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<DetalleInspeccion> model = EntityModel.of(detalle,
			linkTo(methodOn(DetalleInspeccionController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(DetalleInspeccionController.class).findAll()).withRel("detalles-inspeccion"));
		return ResponseEntity.ok(model);
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<DetalleInspeccion> save(@Valid @RequestBody DetalleInspeccionDto dto) throws Exception {
		DetalleInspeccion detalle = new DetalleInspeccion();
		detalle.setValorMedido(dto.getValorMedido());
		detalle.setCumpleEstandar(dto.isCumpleEstandar());

		Inspeccion inspeccion = new Inspeccion();
		inspeccion.setIdInspeccion(dto.getIdInspeccion());
		inspeccion.setEstado(true);
		detalle.setInspeccion(inspeccion);

		EstandarCalidad estandarcalidad = new EstandarCalidad();
		estandarcalidad.setIdEstandar(dto.getIdEstandar());
		estandarcalidad.setEstado(true);
		detalle.setEstandarCalidad(estandarcalidad);

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(detalle));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<DetalleInspeccion> update(@Valid @RequestBody DetalleInspeccionDto dto,
			@PathVariable("id") Integer id) throws Exception {
		DetalleInspeccion detalle = new DetalleInspeccion();
		detalle.setValorMedido(dto.getValorMedido());
		detalle.setCumpleEstandar(dto.isCumpleEstandar());

		Inspeccion inspeccion = new Inspeccion();
		inspeccion.setIdInspeccion(dto.getIdInspeccion());
		inspeccion.setEstado(true);
		detalle.setInspeccion(inspeccion);

		EstandarCalidad estandarcalidad = new EstandarCalidad();
		estandarcalidad.setIdEstandar(dto.getIdEstandar());
		estandarcalidad.setEstado(true);
		detalle.setEstandarCalidad(estandarcalidad);

		return ResponseEntity.ok(service.update(detalle, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
