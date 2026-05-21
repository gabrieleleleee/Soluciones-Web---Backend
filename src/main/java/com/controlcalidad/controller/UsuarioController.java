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

import com.controlcalidad.dto.UsuarioDto;
import com.controlcalidad.model.Rol;
import com.controlcalidad.model.Usuario;
import com.controlcalidad.service.IUsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
	private final IUsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable("id") Integer id) throws Exception {
		return ResponseEntity.ok(service.findById(id));
	}

	@PostMapping
	public ResponseEntity<Usuario> save(@Valid @RequestBody UsuarioDto dto) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setNombreUsuario(dto.getNombreUsuario());
		usuario.setContrasena(dto.getContrasena());
		usuario.setNombreCompleto(dto.getNombreCompleto());
		usuario.setCorreo(dto.getCorreo());
		usuario.setActivo(dto.isActivo());
		if (dto.getIdsRoles() != null) {
			List<Rol> roles = dto.getIdsRoles().stream()
				.map(id -> { Rol r = new Rol(); r.setIdRol(id); r.setEstado(true); return r; })
				.toList();
			usuario.setRoles(roles);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuario));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> update(@Valid @RequestBody UsuarioDto dto,
			@PathVariable("id") Integer id) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setNombreUsuario(dto.getNombreUsuario());
		usuario.setContrasena(dto.getContrasena());
		usuario.setNombreCompleto(dto.getNombreCompleto());
		usuario.setCorreo(dto.getCorreo());
		usuario.setActivo(dto.isActivo());
		if (dto.getIdsRoles() != null) {
			List<Rol> roles = dto.getIdsRoles().stream()
				.map(rolId -> { Rol r = new Rol(); r.setIdRol(rolId); r.setEstado(true); return r; })
				.toList();
			usuario.setRoles(roles);
		}
		return ResponseEntity.ok(service.update(usuario, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
