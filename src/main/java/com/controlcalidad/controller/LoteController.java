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

import com.controlcalidad.dto.LoteDto;
import com.controlcalidad.model.Lote;
import com.controlcalidad.model.Producto;
import com.controlcalidad.repository.IProductoRepository;
import com.controlcalidad.service.ILoteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lotes")
@RequiredArgsConstructor
public class LoteController {
	private final ILoteService service;
	private final IProductoRepository iProductoRepo;

	@GetMapping
	public ResponseEntity<List<Lote>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<Lote>> findById(@PathVariable("id") Integer id) throws Exception {
		Lote lote = service.findById(id);
		EntityModel<Lote> model = EntityModel.of(lote,
			linkTo(methodOn(LoteController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(LoteController.class).findAll()).withRel("lotes"));
		return ResponseEntity.ok(model);
	}

	@PostMapping
	public ResponseEntity<Lote> save(@Valid @RequestBody LoteDto dto) throws Exception {
		Lote lote = new Lote();
		lote.setCodigoLote(dto.getCodigoLote());
		lote.setFechaProduccion(dto.getFechaProduccion());
		lote.setCantidadProducida(dto.getCantidadProducida());
		lote.setEstadoLote(dto.getEstadoLote());
		lote.setObservaciones(dto.getObservaciones());
		lote.setEstado(dto.isEstado());

		lote.setProducto(iProductoRepo.getReferenceById(dto.getIdProducto()));

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(lote));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Lote> update(@Valid @RequestBody LoteDto dto,
			@PathVariable("id") Integer id) throws Exception {
		Lote lote = new Lote();
		lote.setCodigoLote(dto.getCodigoLote());
		lote.setFechaProduccion(dto.getFechaProduccion());
		lote.setCantidadProducida(dto.getCantidadProducida());
		lote.setEstadoLote(dto.getEstadoLote());
		lote.setObservaciones(dto.getObservaciones());
		lote.setEstado(dto.isEstado());

		lote.setProducto(iProductoRepo.getReferenceById(dto.getIdProducto()));

		return ResponseEntity.ok(service.update(lote, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
