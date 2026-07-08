package com.controlcalidad.controller;

import java.util.List;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import com.controlcalidad.dto.CapacitacionPersonalDto;
import com.controlcalidad.model.CapacitacionPersonal;
import com.controlcalidad.service.ICapacitacionPersonalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/capacitaciones")
@RequiredArgsConstructor
public class CapacitacionPersonalController {
	private final ICapacitacionPersonalService service;

	@GetMapping
	public ResponseEntity<List<CapacitacionPersonal>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<CapacitacionPersonal>> findAllPageable(@PageableDefault(size = 10, direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable pageable) throws Exception {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<CapacitacionPersonal>> findById(@PathVariable("id") Integer id) throws Exception {
		CapacitacionPersonal capacitacion = service.findById(id);
		EntityModel<CapacitacionPersonal> model = EntityModel.of(capacitacion,
			linkTo(methodOn(CapacitacionPersonalController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(CapacitacionPersonalController.class).findAll()).withRel("capacitaciones"));
		return ResponseEntity.ok(model);
	}

	@PostMapping
	public ResponseEntity<CapacitacionPersonal> save(@Valid @RequestBody CapacitacionPersonalDto dto) throws Exception {
		CapacitacionPersonal capacitacion = new CapacitacionPersonal();
		capacitacion.setTema(dto.getTema());
		capacitacion.setInstructor(dto.getInstructor());
		capacitacion.setFechaCapacitacion(dto.getFechaCapacitacion());
		capacitacion.setObservaciones(dto.getObservaciones());
		capacitacion.setEstado(dto.isEstado());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(capacitacion));
	}

	@PutMapping("/{id}")
	public ResponseEntity<CapacitacionPersonal> update(@Valid @RequestBody CapacitacionPersonalDto dto,
			@PathVariable("id") Integer id) throws Exception {
		CapacitacionPersonal capacitacion = new CapacitacionPersonal();
		capacitacion.setTema(dto.getTema());
		capacitacion.setInstructor(dto.getInstructor());
		capacitacion.setFechaCapacitacion(dto.getFechaCapacitacion());
		capacitacion.setObservaciones(dto.getObservaciones());
		capacitacion.setEstado(dto.isEstado());

		return ResponseEntity.ok(service.update(capacitacion, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
