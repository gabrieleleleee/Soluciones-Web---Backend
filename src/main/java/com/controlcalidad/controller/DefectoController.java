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

import com.controlcalidad.dto.DefectoDto;
import com.controlcalidad.model.Defecto;
import java.time.LocalDate;
import com.controlcalidad.service.IDefectoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/defectos")
@RequiredArgsConstructor
public class DefectoController {
	private final IDefectoService service;

	@GetMapping
	public ResponseEntity<List<Defecto>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<Defecto>> findById(@PathVariable("id") Integer id) throws Exception {
		Defecto defecto = service.findById(id);
		EntityModel<Defecto> model = EntityModel.of(defecto,
			linkTo(methodOn(DefectoController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(DefectoController.class).findAll()).withRel("defectos"));
		return ResponseEntity.ok(model);
	}

	@PostMapping
	public ResponseEntity<Defecto> save(@Valid @RequestBody DefectoDto dto) throws Exception {
		Defecto defecto = new Defecto();
		defecto.setTipoDefecto(dto.getTipoDefecto());
		defecto.setDescripcion(dto.getDescripcion());
		defecto.setFechaRegistro(java.time.LocalDate.parse(dto.getFechaRegistro()));
		defecto.setEstado(dto.isEstado());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(defecto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Defecto> update(@Valid @RequestBody DefectoDto dto,
			@PathVariable("id") Integer id) throws Exception {
		Defecto defecto = new Defecto();
		defecto.setTipoDefecto(dto.getTipoDefecto());
		defecto.setDescripcion(dto.getDescripcion());
		defecto.setFechaRegistro(java.time.LocalDate.parse(dto.getFechaRegistro()));
		defecto.setEstado(dto.isEstado());

		return ResponseEntity.ok(service.update(defecto, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
