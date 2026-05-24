package com.controlcalidad.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.controlcalidad.model.MateriaPrima;
import com.controlcalidad.repository.IMateriaPrimaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MateriaPrimaService implements IMateriaPrimaService {
	private final IMateriaPrimaRepository repo;

	@Override
	public MateriaPrima save(MateriaPrima materiaPrima) throws Exception {
		return repo.save(materiaPrima);
	}

	@Override
	public MateriaPrima update(MateriaPrima materiaPrima, Integer id) throws Exception {
		materiaPrima.setIdMateriaPrima(id);
		return repo.save(materiaPrima);
	}

	@Override
	public List<MateriaPrima> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public MateriaPrima findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new MateriaPrima());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);
	}
}
