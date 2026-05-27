package com.controlcalidad.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.controlcalidad.model.UnidadMedida;
import com.controlcalidad.repository.IUnidadMedidaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UnidadMedidaService implements IUnidadMedidaService {
	private final IUnidadMedidaRepository repo;

	@Override
	public UnidadMedida save(UnidadMedida unidad) throws Exception {
		return repo.save(unidad);
	}

	@Override
	public UnidadMedida update(UnidadMedida unidad, Integer id) throws Exception {
		unidad.setIdUnidad(id);
		return repo.save(unidad);
	}

	@Override
	public List<UnidadMedida> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public UnidadMedida findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new UnidadMedida());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);
	}
}
