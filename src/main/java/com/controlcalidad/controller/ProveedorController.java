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

import com.controlcalidad.dto.ProveedorDto;
import com.controlcalidad.model.Proveedor;
import com.controlcalidad.service.IProveedorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/proveedores")
@RequiredArgsConstructor
public class ProveedorController {
	private final IProveedorService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<Proveedor>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<Proveedor>> findAllPageable(@PageableDefault(size = 10, direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable pageable) throws Exception {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<Proveedor>> findById(@PathVariable("id") Integer id) throws Exception {
		Proveedor proveedor = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<Proveedor> model = EntityModel.of(proveedor,
			linkTo(methodOn(ProveedorController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(ProveedorController.class).findAll()).withRel("proveedores"));
		return ResponseEntity.ok(model);
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<Proveedor> save(@Valid @RequestBody ProveedorDto dto) throws Exception {
		Proveedor proveedor = new Proveedor();
		proveedor.setRazonSocial(dto.getRazonSocial());
		proveedor.setRuc(dto.getRuc());
		proveedor.setTelefono(dto.getTelefono());
		proveedor.setDireccion(dto.getDireccion());
		proveedor.setEstado(dto.isEstado());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(proveedor));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<Proveedor> update(@Valid @RequestBody ProveedorDto dto,
			@PathVariable("id") Integer id) throws Exception {
		Proveedor proveedor = new Proveedor();
		proveedor.setRazonSocial(dto.getRazonSocial());
		proveedor.setRuc(dto.getRuc());
		proveedor.setTelefono(dto.getTelefono());
		proveedor.setDireccion(dto.getDireccion());
		proveedor.setEstado(dto.isEstado());

		return ResponseEntity.ok(service.update(proveedor, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
