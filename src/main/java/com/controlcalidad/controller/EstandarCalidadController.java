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

import com.controlcalidad.model.EstandarCalidad;
import com.controlcalidad.service.IEstandarCalidadService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/estandares")
@RequiredArgsConstructor
public class EstandarCalidadController {
	private final IEstandarCalidadService service;
	
	@GetMapping // GET, POST, PUT, DELETE
	public List<EstandarCalidad> findAll() throws Exception{
		return service.findAll();
	}
	
	@GetMapping("/{id}") // GET
	public EstandarCalidad findById(@PathVariable("id") Integer id) throws Exception{
		return service.findById(id);
	}
	
	@PostMapping // POST
	public EstandarCalidad save(@RequestBody EstandarCalidad estandar) throws Exception{
		return service.save(estandar);
	}
	
	@PutMapping("/{id}") // PUT
	public EstandarCalidad update(@RequestBody EstandarCalidad estandar, @PathVariable("id") Integer id) throws Exception{
		return service.update(estandar, id);
	}
	
	@DeleteMapping("/{id}") // DELETE
	public void delete(@PathVariable("id") Integer id) throws Exception{
		service.delete(id);
	}
}
