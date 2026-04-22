package com.controlcalidad.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.controlcalidad.model.EstandarCalidad;
import com.controlcalidad.repository.IEstandarCalidadRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstandarCalidadService implements IEstandarCalidadService {
	private final IEstandarCalidadRepository repo;
	
	@Override
	public EstandarCalidad save(EstandarCalidad estandar) throws Exception {
		return repo.save(estandar);
	}

	@Override
	public EstandarCalidad update(EstandarCalidad estandar, Integer id) throws Exception {
		// TODO Logica utilizando ID
		estandar.setIdEstandar(id);
		return repo.save(estandar);
	}

	@Override
	public List<EstandarCalidad> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public EstandarCalidad findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new EstandarCalidad());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);	
	}

}
