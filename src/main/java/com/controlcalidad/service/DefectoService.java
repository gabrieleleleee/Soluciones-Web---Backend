package com.controlcalidad.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.controlcalidad.model.Defecto;
import com.controlcalidad.repository.IDefectoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefectoService implements IDefectoService {
	private final IDefectoRepository repo;

	@Override
	public Defecto save(Defecto defecto) throws Exception {
		return repo.save(defecto);
	}

	@Override
	public Defecto update(Defecto defecto, Integer id) throws Exception {
		defecto.setIdDefecto(id);
		return repo.save(defecto);
	}

	@Override
	public List<Defecto> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public Defecto findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new Defecto());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);
	}
}
