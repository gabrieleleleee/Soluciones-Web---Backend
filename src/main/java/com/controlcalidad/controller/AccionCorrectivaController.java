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

import com.controlcalidad.dto.AccionCorrectivaDto;
import com.controlcalidad.model.AccionCorrectiva;
import java.time.LocalDateTime;
import com.controlcalidad.model.Inspeccion;
import com.controlcalidad.repository.IInspeccionRepository;
import com.controlcalidad.service.IAccionCorrectivaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/acciones-correctivas")
@RequiredArgsConstructor
public class AccionCorrectivaController {
	private final IAccionCorrectivaService service;
	private final IInspeccionRepository iInspeccionRepo;

	@GetMapping
	public ResponseEntity<List<AccionCorrectiva>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<AccionCorrectiva>> findById(@PathVariable("id") Integer id) throws Exception {
		AccionCorrectiva accion = service.findById(id);
		EntityModel<AccionCorrectiva> model = EntityModel.of(accion,
			linkTo(methodOn(AccionCorrectivaController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(AccionCorrectivaController.class).findAll()).withRel("acciones-correctivas"));
		return ResponseEntity.ok(model);
	}

	@PostMapping
	public ResponseEntity<AccionCorrectiva> save(@Valid @RequestBody AccionCorrectivaDto dto) throws Exception {
		AccionCorrectiva accion = new AccionCorrectiva();
		accion.setAccionTomada(dto.getAccionTomada());
		accion.setFechaRegistro(java.time.LocalDateTime.parse(dto.getFechaRegistro()));
		accion.setObservacion(dto.getObservacion());
		accion.setEstado(dto.isEstado());
		accion.setInspeccion(iInspeccionRepo.getReferenceById(dto.getIdInspeccion()));

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(accion));
	}

	@PutMapping("/{id}")
	public ResponseEntity<AccionCorrectiva> update(@Valid @RequestBody AccionCorrectivaDto dto,
			@PathVariable("id") Integer id) throws Exception {
		AccionCorrectiva accion = new AccionCorrectiva();
		accion.setAccionTomada(dto.getAccionTomada());
		accion.setFechaRegistro(java.time.LocalDateTime.parse(dto.getFechaRegistro()));
		accion.setObservacion(dto.getObservacion());
		accion.setEstado(dto.isEstado());
		accion.setInspeccion(iInspeccionRepo.getReferenceById(dto.getIdInspeccion()));

		return ResponseEntity.ok(service.update(accion, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
