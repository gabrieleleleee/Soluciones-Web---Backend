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
import com.controlcalidad.dto.MaquinariaEquipoDto;
import com.controlcalidad.model.MaquinariaEquipo;
import com.controlcalidad.model.Proveedor;
import com.controlcalidad.repository.IProveedorRepository;
import com.controlcalidad.service.IMaquinariaEquipoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/maquinarias")
@RequiredArgsConstructor
public class MaquinariaEquipoController {
	private final IMaquinariaEquipoService service;
	private final IProveedorRepository iProveedorRepo;

	@GetMapping
	public ResponseEntity<List<MaquinariaEquipo>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<MaquinariaEquipo>> findById(@PathVariable("id") Integer id) throws Exception {
		MaquinariaEquipo maquinaria = service.findById(id);
		EntityModel<MaquinariaEquipo> model = EntityModel.of(maquinaria,
			linkTo(methodOn(MaquinariaEquipoController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(MaquinariaEquipoController.class).findAll()).withRel("maquinarias"));
		return ResponseEntity.ok(model);
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<MaquinariaEquipo>> findAllPageable(@PageableDefault(size = 10, sort = "id", direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable pageable) throws Exception {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	@PostMapping
	public ResponseEntity<MaquinariaEquipo> save(@Valid @RequestBody MaquinariaEquipoDto dto) throws Exception {
		MaquinariaEquipo maquinaria = new MaquinariaEquipo();
		maquinaria.setNombreEquipo(dto.getNombreEquipo());
		maquinaria.setDescripcion(dto.getDescripcion());
		maquinaria.setEstado(dto.isEstado());
		maquinaria.setProveedor(iProveedorRepo.getReferenceById(dto.getIdProveedor()));

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(maquinaria));
	}

	@PutMapping("/{id}")
	public ResponseEntity<MaquinariaEquipo> update(@Valid @RequestBody MaquinariaEquipoDto dto,
			@PathVariable("id") Integer id) throws Exception {
		MaquinariaEquipo maquinaria = new MaquinariaEquipo();
		maquinaria.setNombreEquipo(dto.getNombreEquipo());
		maquinaria.setDescripcion(dto.getDescripcion());
		maquinaria.setEstado(dto.isEstado());
		maquinaria.setProveedor(iProveedorRepo.getReferenceById(dto.getIdProveedor()));

		return ResponseEntity.ok(service.update(maquinaria, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
