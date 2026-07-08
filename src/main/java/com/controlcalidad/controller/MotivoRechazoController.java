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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import com.controlcalidad.dto.MotivoRechazoDto;
import com.controlcalidad.model.MotivoRechazo;
import com.controlcalidad.service.IMotivoRechazoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/motivos-rechazo")
@RequiredArgsConstructor
public class MotivoRechazoController {
	private final IMotivoRechazoService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<MotivoRechazo>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<MotivoRechazo>> findById(@PathVariable("id") Integer id) throws Exception {
		MotivoRechazo motivo = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<MotivoRechazo> model = EntityModel.of(motivo,
			linkTo(methodOn(MotivoRechazoController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(MotivoRechazoController.class).findAll()).withRel("motivos-rechazo"));
		return ResponseEntity.ok(model);
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<MotivoRechazo>> findAllPageable(@PageableDefault(size = 10, sort = "id", direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable pageable) throws Exception {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<MotivoRechazo> save(@Valid @RequestBody MotivoRechazoDto dto) throws Exception {
		MotivoRechazo motivo = new MotivoRechazo();
		motivo.setCodigoFalla(dto.getCodigoFalla());
		motivo.setDescripcion(dto.getDescripcion());
		motivo.setEstado(dto.isEstado());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(motivo));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<MotivoRechazo> update(@Valid @RequestBody MotivoRechazoDto dto,
			@PathVariable("id") Integer id) throws Exception {
		MotivoRechazo motivo = new MotivoRechazo();
		motivo.setCodigoFalla(dto.getCodigoFalla());
		motivo.setDescripcion(dto.getDescripcion());
		motivo.setEstado(dto.isEstado());

		return ResponseEntity.ok(service.update(motivo, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
