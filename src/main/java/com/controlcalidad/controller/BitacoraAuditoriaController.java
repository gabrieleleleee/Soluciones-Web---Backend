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
import com.controlcalidad.model.BitacoraAuditoria;
import com.controlcalidad.service.IBitacoraAuditoriaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/bitacora-auditoria")
@RequiredArgsConstructor
public class BitacoraAuditoriaController {
	private final IBitacoraAuditoriaService service;

	@GetMapping
	public List<BitacoraAuditoria> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public BitacoraAuditoria findById(@PathVariable("id") Integer id) throws Exception {
		return service.findById(id);
	}

	@PostMapping
	public BitacoraAuditoria save(@RequestBody BitacoraAuditoria bitacora) throws Exception {
		return service.save(bitacora);
	}

	@PutMapping("/{id}")
	public BitacoraAuditoria update(@RequestBody BitacoraAuditoria bitacora, @PathVariable("id") Integer id) throws Exception {
		return service.update(bitacora, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
	}
}
