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

import com.controlcalidad.dto.BitacoraAuditoriaDto;
import com.controlcalidad.model.BitacoraAuditoria;
import com.controlcalidad.service.IBitacoraAuditoriaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/bitacora-auditoria")
@RequiredArgsConstructor
public class BitacoraAuditoriaController {
	private final IBitacoraAuditoriaService service;

	// GET ALL - Lista normal (compatible con frontend Angular)
	@GetMapping
	public ResponseEntity<List<BitacoraAuditoria>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	// GET BY ID - HATEOAS Nivel 3: incluye links de navegacion
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<BitacoraAuditoria>> findById(@PathVariable("id") Integer id) throws Exception {
		BitacoraAuditoria bitacora = service.findById(id);
		// Nivel 3 Richardson: self link + coleccion link
		EntityModel<BitacoraAuditoria> model = EntityModel.of(bitacora,
			linkTo(methodOn(BitacoraAuditoriaController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(BitacoraAuditoriaController.class).findAll()).withRel("bitacora-auditoria"));
		return ResponseEntity.ok(model);
	}

	// POST - DTO con validacion (@Valid)
	@PostMapping
	public ResponseEntity<BitacoraAuditoria> save(@Valid @RequestBody BitacoraAuditoriaDto dto) throws Exception {
		BitacoraAuditoria bitacora = new BitacoraAuditoria();
		bitacora.setAccion(dto.getAccion());
		bitacora.setTabla(dto.getTabla());
		bitacora.setUsuarioResponsable(dto.getUsuarioResponsable());
		bitacora.setDescripcion(dto.getDescripcion());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(bitacora));
	}

	// PUT - DTO con validacion (@Valid)
	@PutMapping("/{id}")
	public ResponseEntity<BitacoraAuditoria> update(@Valid @RequestBody BitacoraAuditoriaDto dto,
			@PathVariable("id") Integer id) throws Exception {
		BitacoraAuditoria bitacora = new BitacoraAuditoria();
		bitacora.setAccion(dto.getAccion());
		bitacora.setTabla(dto.getTabla());
		bitacora.setUsuarioResponsable(dto.getUsuarioResponsable());
		bitacora.setDescripcion(dto.getDescripcion());

		return ResponseEntity.ok(service.update(bitacora, id));
	}

	// DELETE - 204 No Content
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
