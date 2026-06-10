package com.controlcalidad.controller;

import java.util.List;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.controlcalidad.dto.HistorialMantenimientoDto;
import com.controlcalidad.model.HistorialMantenimiento;
import com.controlcalidad.model.MaquinariaEquipo;
import com.controlcalidad.repository.IMaquinariaEquipoRepository;
import com.controlcalidad.service.IHistorialMantenimientoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/historiales-mantenimiento")
@RequiredArgsConstructor
public class HistorialMantenimientoController {
	private final IHistorialMantenimientoService service;
	private final IMaquinariaEquipoRepository iMaquinariaRepo;

	@GetMapping
	public ResponseEntity<List<HistorialMantenimiento>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<HistorialMantenimiento>> findById(@PathVariable("id") Integer id) throws Exception {
		HistorialMantenimiento historial = service.findById(id);
		EntityModel<HistorialMantenimiento> model = EntityModel.of(historial,
			linkTo(methodOn(HistorialMantenimientoController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(HistorialMantenimientoController.class).findAll()).withRel("historiales-mantenimiento"));
		return ResponseEntity.ok(model);
	}

	@PostMapping
	public ResponseEntity<HistorialMantenimiento> save(@Valid @RequestBody HistorialMantenimientoDto dto) throws Exception {
		HistorialMantenimiento historial = new HistorialMantenimiento();
		historial.setFechaMantenimiento(dto.getFechaMantenimiento());
		historial.setTipoMantenimiento(dto.getTipoMantenimiento());
		historial.setDescripcionActividad(dto.getDescripcionActividad());
		historial.setTecnicoResponsable(dto.getTecnicoResponsable());
		historial.setCosto(dto.getCosto());
		historial.setEstado(dto.isEstado());
		historial.setMaquinariaEquipo(iMaquinariaRepo.getReferenceById(dto.getIdEquipo()));

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(historial));
	}

	@PutMapping("/{id}")
	public ResponseEntity<HistorialMantenimiento> update(@Valid @RequestBody HistorialMantenimientoDto dto,
			@PathVariable("id") Integer id) throws Exception {
		HistorialMantenimiento historial = new HistorialMantenimiento();
		historial.setFechaMantenimiento(dto.getFechaMantenimiento());
		historial.setTipoMantenimiento(dto.getTipoMantenimiento());
		historial.setDescripcionActividad(dto.getDescripcionActividad());
		historial.setTecnicoResponsable(dto.getTecnicoResponsable());
		historial.setCosto(dto.getCosto());
		historial.setEstado(dto.isEstado());
		historial.setMaquinariaEquipo(iMaquinariaRepo.getReferenceById(dto.getIdEquipo()));

		return ResponseEntity.ok(service.update(historial, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
