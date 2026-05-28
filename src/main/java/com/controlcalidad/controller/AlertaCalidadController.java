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

import com.controlcalidad.dto.AlertaCalidadDto;
import com.controlcalidad.model.AlertaCalidad;
import java.time.LocalDate;
import com.controlcalidad.service.IAlertaCalidadService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/alertas")
@RequiredArgsConstructor
public class AlertaCalidadController {
	private final IAlertaCalidadService service;

	@GetMapping
	public ResponseEntity<List<AlertaCalidad>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<AlertaCalidad>> findById(@PathVariable("id") Integer id) throws Exception {
		AlertaCalidad alerta = service.findById(id);
		EntityModel<AlertaCalidad> model = EntityModel.of(alerta,
			linkTo(methodOn(AlertaCalidadController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(AlertaCalidadController.class).findAll()).withRel("alertas"));
		return ResponseEntity.ok(model);
	}

	@PostMapping
	public ResponseEntity<AlertaCalidad> save(@Valid @RequestBody AlertaCalidadDto dto) throws Exception {
		AlertaCalidad alerta = new AlertaCalidad();
		alerta.setTitulo(dto.getTitulo());
		alerta.setMensaje(dto.getMensaje());
		alerta.setFechaAlerta(java.time.LocalDate.parse(dto.getFechaAlerta()));
		alerta.setEstado(dto.isEstado());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alerta));
	}

	@PutMapping("/{id}")
	public ResponseEntity<AlertaCalidad> update(@Valid @RequestBody AlertaCalidadDto dto,
			@PathVariable("id") Integer id) throws Exception {
		AlertaCalidad alerta = new AlertaCalidad();
		alerta.setTitulo(dto.getTitulo());
		alerta.setMensaje(dto.getMensaje());
		alerta.setFechaAlerta(java.time.LocalDate.parse(dto.getFechaAlerta()));
		alerta.setEstado(dto.isEstado());

		return ResponseEntity.ok(service.update(alerta, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
