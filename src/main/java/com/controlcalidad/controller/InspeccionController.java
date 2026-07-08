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
import com.controlcalidad.dto.InspeccionDto;
import com.controlcalidad.model.Inspeccion;
import com.controlcalidad.model.Lote;
import com.controlcalidad.repository.ILoteRepository;
import com.controlcalidad.model.MateriaPrima;
import com.controlcalidad.repository.IMateriaPrimaRepository;
import com.controlcalidad.service.IInspeccionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inspecciones")
@RequiredArgsConstructor
public class InspeccionController {
	private final IInspeccionService service;
	private final ILoteRepository iLoteRepo;
	private final IMateriaPrimaRepository iMateriaPrimaRepo;

	@GetMapping
	public ResponseEntity<List<Inspeccion>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<Inspeccion>> findAllPageable(@PageableDefault(size = 10, direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable pageable) throws Exception {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<Inspeccion>> findById(@PathVariable("id") Integer id) throws Exception {
		Inspeccion inspeccion = service.findById(id);
		EntityModel<Inspeccion> model = EntityModel.of(inspeccion,
			linkTo(methodOn(InspeccionController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(InspeccionController.class).findAll()).withRel("inspecciones"));
		return ResponseEntity.ok(model);
	}

	@PostMapping
	public ResponseEntity<Inspeccion> save(@Valid @RequestBody InspeccionDto dto) throws Exception {
		Inspeccion inspeccion = new Inspeccion();
		inspeccion.setFechaHora(dto.getFechaHora());
		inspeccion.setObservacionesGenerales(dto.getObservacionesGenerales());
		inspeccion.setResultadoAprobado(dto.isResultadoAprobado());
		inspeccion.setEstado(dto.isEstado());
		inspeccion.setLote(iLoteRepo.getReferenceById(dto.getIdLote()));
		inspeccion.setMateriaPrima(iMateriaPrimaRepo.getReferenceById(dto.getIdMateriaPrima()));

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(inspeccion));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Inspeccion> update(@Valid @RequestBody InspeccionDto dto,
			@PathVariable("id") Integer id) throws Exception {
		Inspeccion inspeccion = new Inspeccion();
		inspeccion.setFechaHora(dto.getFechaHora());
		inspeccion.setObservacionesGenerales(dto.getObservacionesGenerales());
		inspeccion.setResultadoAprobado(dto.isResultadoAprobado());
		inspeccion.setEstado(dto.isEstado());
		inspeccion.setLote(iLoteRepo.getReferenceById(dto.getIdLote()));
		inspeccion.setMateriaPrima(iMateriaPrimaRepo.getReferenceById(dto.getIdMateriaPrima()));

		return ResponseEntity.ok(service.update(inspeccion, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
