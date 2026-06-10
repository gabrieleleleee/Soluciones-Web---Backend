package com.controlcalidad.controller;

import java.util.List;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.controlcalidad.dto.DevolucionLoteDto;
import com.controlcalidad.model.DevolucionLote;
import com.controlcalidad.model.Lote;
import com.controlcalidad.repository.ILoteRepository;
import com.controlcalidad.service.IDevolucionLoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/devoluciones")
@RequiredArgsConstructor
public class DevolucionLoteController {
	private final IDevolucionLoteService service;
	private final ILoteRepository iLoteRepo;

	@GetMapping
	public ResponseEntity<List<DevolucionLote>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<DevolucionLote>> findById(@PathVariable("id") Integer id) throws Exception {
		DevolucionLote devolucion = service.findById(id);
		EntityModel<DevolucionLote> model = EntityModel.of(devolucion,
			linkTo(methodOn(DevolucionLoteController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(DevolucionLoteController.class).findAll()).withRel("devoluciones"));
		return ResponseEntity.ok(model);
	}

	@PostMapping
	public ResponseEntity<DevolucionLote> save(@Valid @RequestBody DevolucionLoteDto dto) throws Exception {
		DevolucionLote devolucion = new DevolucionLote();
		devolucion.setFechaDevolucion(dto.getFechaDevolucion());
		devolucion.setMotivoDevolucion(dto.getMotivoDevolucion());
		devolucion.setCantidadDevuelta(dto.getCantidadDevuelta());
		devolucion.setEstado(dto.isEstado());
		devolucion.setLote(iLoteRepo.getReferenceById(dto.getIdLote()));

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(devolucion));
	}

	@PutMapping("/{id}")
	public ResponseEntity<DevolucionLote> update(@Valid @RequestBody DevolucionLoteDto dto,
			@PathVariable("id") Integer id) throws Exception {
		DevolucionLote devolucion = new DevolucionLote();
		devolucion.setFechaDevolucion(dto.getFechaDevolucion());
		devolucion.setMotivoDevolucion(dto.getMotivoDevolucion());
		devolucion.setCantidadDevuelta(dto.getCantidadDevuelta());
		devolucion.setEstado(dto.isEstado());
		devolucion.setLote(iLoteRepo.getReferenceById(dto.getIdLote()));

		return ResponseEntity.ok(service.update(devolucion, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
