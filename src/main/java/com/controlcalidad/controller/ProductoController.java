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

import com.controlcalidad.dto.ProductoDto;
import com.controlcalidad.model.Producto;
import com.controlcalidad.service.IProductoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {
	private final IProductoService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<Producto>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<Producto>> findById(@PathVariable("id") Integer id) throws Exception {
		Producto producto = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<Producto> model = EntityModel.of(producto,
			linkTo(methodOn(ProductoController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(ProductoController.class).findAll()).withRel("productos"));
		return ResponseEntity.ok(model);
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<Producto>> findAllPageable(@PageableDefault(size = 10, sort = "id", direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable pageable) throws Exception {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<Producto> save(@Valid @RequestBody ProductoDto dto) throws Exception {
		Producto producto = new Producto();
		producto.setCodigo(dto.getCodigo());
		producto.setNombre(dto.getNombre());
		producto.setDescripcion(dto.getDescripcion());
		producto.setUnidadMedida(dto.getUnidadMedida());
		producto.setPrecioUnitario(dto.getPrecioUnitario());
		producto.setEstado(dto.isEstado());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(producto));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<Producto> update(@Valid @RequestBody ProductoDto dto,
			@PathVariable("id") Integer id) throws Exception {
		Producto producto = new Producto();
		producto.setCodigo(dto.getCodigo());
		producto.setNombre(dto.getNombre());
		producto.setDescripcion(dto.getDescripcion());
		producto.setUnidadMedida(dto.getUnidadMedida());
		producto.setPrecioUnitario(dto.getPrecioUnitario());
		producto.setEstado(dto.isEstado());

		return ResponseEntity.ok(service.update(producto, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
