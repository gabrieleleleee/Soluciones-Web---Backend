package com.controlcalidad.controller;

import java.util.List;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.controlcalidad.dto.EstandarCalidadDto;
import com.controlcalidad.model.EstandarCalidad;
import com.controlcalidad.model.Producto;
import com.controlcalidad.repository.IProductoRepository;
import com.controlcalidad.service.IEstandarCalidadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/estandares")
@RequiredArgsConstructor
public class EstandarCalidadController {
	private final IEstandarCalidadService service;
	private final IProductoRepository iProductoRepo;

	@GetMapping
	public ResponseEntity<List<EstandarCalidad>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<EstandarCalidad>> findById(@PathVariable("id") Integer id) throws Exception {
		EstandarCalidad estandar = service.findById(id);
		EntityModel<EstandarCalidad> model = EntityModel.of(estandar,
			linkTo(methodOn(EstandarCalidadController.class).findById(id)).withSelfRel(),
			linkTo(methodOn(EstandarCalidadController.class).findAll()).withRel("estandares"));
		return ResponseEntity.ok(model);
	}

	@PostMapping
	public ResponseEntity<EstandarCalidad> save(@Valid @RequestBody EstandarCalidadDto dto) throws Exception {
		EstandarCalidad estandar = new EstandarCalidad();
		estandar.setNombreParametro(dto.getNombreParametro());
		estandar.setUnidadMedida(dto.getUnidadMedida());
		estandar.setValorMinimo(dto.getValorMinimo());
		estandar.setValorMaximo(dto.getValorMaximo());
		estandar.setDescripcion(dto.getDescripcion());
		estandar.setEstado(dto.isEstado());
		estandar.setProducto(iProductoRepo.getReferenceById(dto.getIdProducto()));

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(estandar));
	}

	@PutMapping("/{id}")
	public ResponseEntity<EstandarCalidad> update(@Valid @RequestBody EstandarCalidadDto dto,
			@PathVariable("id") Integer id) throws Exception {
		EstandarCalidad estandar = new EstandarCalidad();
		estandar.setNombreParametro(dto.getNombreParametro());
		estandar.setUnidadMedida(dto.getUnidadMedida());
		estandar.setValorMinimo(dto.getValorMinimo());
		estandar.setValorMaximo(dto.getValorMaximo());
		estandar.setDescripcion(dto.getDescripcion());
		estandar.setEstado(dto.isEstado());
		estandar.setProducto(iProductoRepo.getReferenceById(dto.getIdProducto()));

		return ResponseEntity.ok(service.update(estandar, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
