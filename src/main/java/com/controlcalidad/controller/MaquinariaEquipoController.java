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

import com.controlcalidad.dto.MaquinariaEquipoDto;
import com.controlcalidad.model.MaquinariaEquipo;
import com.controlcalidad.model.Proveedor;
import com.controlcalidad.service.IMaquinariaEquipoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/maquinarias")
@RequiredArgsConstructor
public class MaquinariaEquipoController {
	private final IMaquinariaEquipoService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<MaquinariaEquipo>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<MaquinariaEquipo>> findById(@PathVariable("id") Integer id) throws Exception {
		MaquinariaEquipo maquinaria = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<MaquinariaEquipo> model = EntityModel.of(maquinaria,
			linkTo(methodOn(MaquinariaEquipoController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(MaquinariaEquipoController.class).findAll()).withRel("maquinarias"));
		return ResponseEntity.ok(model);
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<MaquinariaEquipo> save(@Valid @RequestBody MaquinariaEquipoDto dto) throws Exception {
		MaquinariaEquipo maquinaria = new MaquinariaEquipo();
		maquinaria.setNombreEquipo(dto.getNombreEquipo());
		maquinaria.setDescripcion(dto.getDescripcion());
		maquinaria.setEstado(dto.isEstado());

		Proveedor proveedor = new Proveedor();
		proveedor.setIdProveedor(dto.getIdProveedor());
		proveedor.setEstado(true);
		maquinaria.setProveedor(proveedor);

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(maquinaria));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<MaquinariaEquipo> update(@Valid @RequestBody MaquinariaEquipoDto dto,
			@PathVariable("id") Integer id) throws Exception {
		MaquinariaEquipo maquinaria = new MaquinariaEquipo();
		maquinaria.setNombreEquipo(dto.getNombreEquipo());
		maquinaria.setDescripcion(dto.getDescripcion());
		maquinaria.setEstado(dto.isEstado());

		Proveedor proveedor = new Proveedor();
		proveedor.setIdProveedor(dto.getIdProveedor());
		proveedor.setEstado(true);
		maquinaria.setProveedor(proveedor);

		return ResponseEntity.ok(service.update(maquinaria, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
