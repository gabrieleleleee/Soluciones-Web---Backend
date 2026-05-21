package com.controlcalidad.controller;

import java.util.List;

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

import com.controlcalidad.dto.RolDto;
import com.controlcalidad.model.Rol;
import com.controlcalidad.service.IRolService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RolController {
	private final IRolService service;

	@GetMapping
	public ResponseEntity<List<Rol>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Rol> findById(@PathVariable("id") Integer id) throws Exception {
		return ResponseEntity.ok(service.findById(id));
	}

	@PostMapping
	public ResponseEntity<Rol> save(@Valid @RequestBody RolDto dto) throws Exception {
		Rol rol = new Rol();
		rol.setNombre(dto.getNombre());
		rol.setDescripcion(dto.getDescripcion());
		rol.setEstado(dto.isEstado());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(rol));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Rol> update(@Valid @RequestBody RolDto dto,
			@PathVariable("id") Integer id) throws Exception {
		Rol rol = new Rol();
		rol.setNombre(dto.getNombre());
		rol.setDescripcion(dto.getDescripcion());
		rol.setEstado(dto.isEstado());
		return ResponseEntity.ok(service.update(rol, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
