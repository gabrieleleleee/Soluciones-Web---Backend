package com.controlcalidad.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.controlcalidad.model.MaquinariaEquipo;
import com.controlcalidad.repository.IMaquinariaEquipoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MaquinariaEquipoService implements IMaquinariaEquipoService {
	private final IMaquinariaEquipoRepository repo;

	@Override
	public MaquinariaEquipo save(MaquinariaEquipo maquinaria) throws Exception {
		return repo.save(maquinaria);
	}

	@Override
	public MaquinariaEquipo update(MaquinariaEquipo maquinaria, Integer id) throws Exception {
		maquinaria.setIdEquipo(id);
		return repo.save(maquinaria);
	}

	@Override
	public List<MaquinariaEquipo> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public MaquinariaEquipo findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new MaquinariaEquipo());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);
	}
}
