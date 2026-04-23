package com.controlcalidad.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.controlcalidad.model.Lote;
import com.controlcalidad.repository.ILoteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoteService implements ILoteService {
	private final ILoteRepository repo;
	
	@Override
	public Lote save(Lote lote) throws Exception {
		return repo.save(lote);
	}

	@Override
	public Lote update(Lote lote, Integer id) throws Exception {
		// TODO Logica utilizando ID
		lote.setIdLote(id);
		return repo.save(lote);
	}

	@Override
	public List<Lote> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public Lote findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new Lote());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);	
	}

}
