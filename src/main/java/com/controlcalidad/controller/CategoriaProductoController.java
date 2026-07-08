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

import com.controlcalidad.dto.CategoriaProductoDto;
import com.controlcalidad.model.CategoriaProducto;
import com.controlcalidad.service.ICategoriaProductoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaProductoController {
	private final ICategoriaProductoService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<CategoriaProducto>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<CategoriaProducto>> findById(@PathVariable("id") Integer id) throws Exception {
		CategoriaProducto categoria = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<CategoriaProducto> model = EntityModel.of(categoria,
			linkTo(methodOn(CategoriaProductoController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(CategoriaProductoController.class).findAll()).withRel("categorias"));
		return ResponseEntity.ok(model);
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<CategoriaProducto>> findAllPageable(@PageableDefault(size = 10, sort = "id", direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable pageable) throws Exception {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<CategoriaProducto> save(@Valid @RequestBody CategoriaProductoDto dto) throws Exception {
		CategoriaProducto categoria = new CategoriaProducto();
		categoria.setNombre(dto.getNombre());
		categoria.setDescripcion(dto.getDescripcion());
		categoria.setEstado(dto.isEstado());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(categoria));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaProducto> update(@Valid @RequestBody CategoriaProductoDto dto,
			@PathVariable("id") Integer id) throws Exception {
		CategoriaProducto categoria = new CategoriaProducto();
		categoria.setNombre(dto.getNombre());
		categoria.setDescripcion(dto.getDescripcion());
		categoria.setEstado(dto.isEstado());

		return ResponseEntity.ok(service.update(categoria, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
