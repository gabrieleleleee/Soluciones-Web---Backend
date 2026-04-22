package com.controlcalidad.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlcalidad.model.Usuario;
import com.controlcalidad.service.IUsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
	private final IUsuarioService service;
	
	@GetMapping // GET, POST, PUT, DELETE
	public List<Usuario> findAll() throws Exception{
		return service.findAll();
	}
	
	@GetMapping("/{id}") // GET
	public Usuario findById(@PathVariable("id") Integer id) throws Exception{
		return service.findById(id);
	}
	
	@PostMapping // POST
	public Usuario save(@RequestBody Usuario usuario) throws Exception{
		return service.save(usuario);
	}
	
	@PutMapping("/{id}") // PUT
	public Usuario update(@RequestBody Usuario usuario, @PathVariable("id") Integer id) throws Exception{
		return service.update(usuario, id);
	}
	
	@DeleteMapping("/{id}") // DELETE
	public void delete(@PathVariable("id") Integer id) throws Exception{
		service.delete(id);
	}
}
