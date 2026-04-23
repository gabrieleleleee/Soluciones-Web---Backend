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

import com.controlcalidad.model.Lote;
import com.controlcalidad.service.ILoteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lotes")
@RequiredArgsConstructor
public class LoteController {
	private final ILoteService service;
	
	@GetMapping // GET, POST, PUT, DELETE
	public List<Lote> findAll() throws Exception{
		return service.findAll();
	}
	
	@GetMapping("/{id}") // GET
	public Lote findById(@PathVariable("id") Integer id) throws Exception{
		return service.findById(id);
	}
	
	@PostMapping // POST
	public Lote save(@RequestBody Lote lote) throws Exception{
		return service.save(lote);
	}
	
	@PutMapping("/{id}") // PUT
	public Lote update(@RequestBody Lote lote, @PathVariable("id") Integer id) throws Exception{
		return service.update(lote, id);
	}
	
	@DeleteMapping("/{id}") // DELETE
	public void delete(@PathVariable("id") Integer id) throws Exception{
		service.delete(id);
	}
}
