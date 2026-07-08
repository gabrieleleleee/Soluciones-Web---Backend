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
import com.controlcalidad.dto.AccionCorrectivaDto;
import com.controlcalidad.model.AccionCorrectiva;
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

	@GetMapping("/pageable")
	public ResponseEntity<Page<AccionCorrectiva>> findAllPageable(@PageableDefault(size = 10, sort = "id", direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable pageable) throws Exception {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	@PostMapping
	public ResponseEntity<AccionCorrectiva> save(@Valid @RequestBody AccionCorrectivaDto dto) throws Exception {
		AccionCorrectiva accion = new AccionCorrectiva();
		accion.setAccionTomada(dto.getAccionTomada());
		accion.setFechaRegistro(dto.getFechaRegistro());
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
		accion.setFechaRegistro(dto.getFechaRegistro());
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
