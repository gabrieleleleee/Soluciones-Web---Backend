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

import com.controlcalidad.dto.HistorialMantenimientoDto;
import com.controlcalidad.model.HistorialMantenimiento;
import com.controlcalidad.model.MaquinariaEquipo;
import com.controlcalidad.service.IHistorialMantenimientoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/historiales-mantenimiento")
@RequiredArgsConstructor
public class HistorialMantenimientoController {
	private final IHistorialMantenimientoService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<HistorialMantenimiento>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<HistorialMantenimiento>> findById(@PathVariable("id") Integer id) throws Exception {
		HistorialMantenimiento historial = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<HistorialMantenimiento> model = EntityModel.of(historial,
			linkTo(methodOn(HistorialMantenimientoController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(HistorialMantenimientoController.class).findAll()).withRel("historiales-mantenimiento"));
		return ResponseEntity.ok(model);
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<HistorialMantenimiento> save(@Valid @RequestBody HistorialMantenimientoDto dto) throws Exception {
		HistorialMantenimiento historial = new HistorialMantenimiento();
		historial.setTipoMantenimiento(dto.getTipoMantenimiento());
		historial.setDescripcionActividad(dto.getDescripcionActividad());
		historial.setTecnicoResponsable(dto.getTecnicoResponsable());
		historial.setCosto(dto.getCosto());
		historial.setEstado(dto.isEstado());

		MaquinariaEquipo maquinariaequipo = new MaquinariaEquipo();
		maquinariaequipo.setIdEquipo(dto.getIdEquipo());
		maquinariaequipo.setEstado(true);
		historial.setMaquinariaEquipo(maquinariaequipo);

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(historial));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<HistorialMantenimiento> update(@Valid @RequestBody HistorialMantenimientoDto dto,
			@PathVariable("id") Integer id) throws Exception {
		HistorialMantenimiento historial = new HistorialMantenimiento();
		historial.setTipoMantenimiento(dto.getTipoMantenimiento());
		historial.setDescripcionActividad(dto.getDescripcionActividad());
		historial.setTecnicoResponsable(dto.getTecnicoResponsable());
		historial.setCosto(dto.getCosto());
		historial.setEstado(dto.isEstado());

		MaquinariaEquipo maquinariaequipo = new MaquinariaEquipo();
		maquinariaequipo.setIdEquipo(dto.getIdEquipo());
		maquinariaequipo.setEstado(true);
		historial.setMaquinariaEquipo(maquinariaequipo);

		return ResponseEntity.ok(service.update(historial, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
