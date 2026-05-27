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

import com.controlcalidad.dto.EstandarCalidadDto;
import com.controlcalidad.model.EstandarCalidad;
import com.controlcalidad.model.Producto;
import com.controlcalidad.service.IEstandarCalidadService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/estandares")
@RequiredArgsConstructor
public class EstandarCalidadController {
	private final IEstandarCalidadService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<EstandarCalidad>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<EstandarCalidad>> findById(@PathVariable("id") Integer id) throws Exception {
		EstandarCalidad estandar = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<EstandarCalidad> model = EntityModel.of(estandar,
			linkTo(methodOn(EstandarCalidadController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(EstandarCalidadController.class).findAll()).withRel("estandares"));
		return ResponseEntity.ok(model);
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<EstandarCalidad> save(@Valid @RequestBody EstandarCalidadDto dto) throws Exception {
		EstandarCalidad estandar = new EstandarCalidad();
		estandar.setNombreParametro(dto.getNombreParametro());
		estandar.setUnidadMedida(dto.getUnidadMedida());
		estandar.setValorMinimo(dto.getValorMinimo());
		estandar.setValorMaximo(dto.getValorMaximo());
		estandar.setDescripcion(dto.getDescripcion());
		estandar.setEstado(dto.isEstado());

		Producto producto = new Producto();
		producto.setIdProducto(dto.getIdProducto());
		producto.setEstado(true);
		estandar.setProducto(producto);

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(estandar));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<EstandarCalidad> update(@Valid @RequestBody EstandarCalidadDto dto,
			@PathVariable("id") Integer id) throws Exception {
		EstandarCalidad estandar = new EstandarCalidad();
		estandar.setNombreParametro(dto.getNombreParametro());
		estandar.setUnidadMedida(dto.getUnidadMedida());
		estandar.setValorMinimo(dto.getValorMinimo());
		estandar.setValorMaximo(dto.getValorMaximo());
		estandar.setDescripcion(dto.getDescripcion());
		estandar.setEstado(dto.isEstado());

		Producto producto = new Producto();
		producto.setIdProducto(dto.getIdProducto());
		producto.setEstado(true);
		estandar.setProducto(producto);

		return ResponseEntity.ok(service.update(estandar, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
