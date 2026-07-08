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

	@GetMapping
	public ResponseEntity<List<BitacoraAuditoria>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<BitacoraAuditoria>> findAllPageable(@PageableDefault(size = 10, direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable pageable) throws Exception {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<BitacoraAuditoria>> findById(@PathVariable("id") Integer id) throws Exception {
		BitacoraAuditoria bitacora = service.findById(id);
		EntityModel<BitacoraAuditoria> model = EntityModel.of(bitacora,
			linkTo(methodOn(BitacoraAuditoriaController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(BitacoraAuditoriaController.class).findAll()).withRel("bitacora-auditoria"));
		return ResponseEntity.ok(model);
	}

	@PostMapping
	public ResponseEntity<BitacoraAuditoria> save(@Valid @RequestBody BitacoraAuditoriaDto dto) throws Exception {
		BitacoraAuditoria bitacora = new BitacoraAuditoria();
		bitacora.setAccion(dto.getAccion());
		bitacora.setTabla(dto.getTabla());
		bitacora.setUsuarioResponsable(dto.getUsuarioResponsable());
		bitacora.setFechaHora(dto.getFechaHora());
		bitacora.setDescripcion(dto.getDescripcion());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(bitacora));
	}

	@PutMapping("/{id}")
	public ResponseEntity<BitacoraAuditoria> update(@Valid @RequestBody BitacoraAuditoriaDto dto,
			@PathVariable("id") Integer id) throws Exception {
		BitacoraAuditoria bitacora = new BitacoraAuditoria();
		bitacora.setAccion(dto.getAccion());
		bitacora.setTabla(dto.getTabla());
		bitacora.setUsuarioResponsable(dto.getUsuarioResponsable());
		bitacora.setFechaHora(dto.getFechaHora());
		bitacora.setDescripcion(dto.getDescripcion());

		return ResponseEntity.ok(service.update(bitacora, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
