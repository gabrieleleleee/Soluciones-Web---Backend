package com.controlcalidad.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.controlcalidad.model.Rol;
import com.controlcalidad.repository.IRolRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolService implements IRolService {
	private final IRolRepository repo;
	
	@Override
	public Rol save(Rol rol) throws Exception {
		return repo.save(rol);
	}

	@Override
	public Rol update(Rol rol, Integer id) throws Exception {
		// TODO Logica utilizando ID
		rol.setIdRol(id);
		return repo.save(rol);
	}

	@Override
	public List<Rol> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public Rol findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new Rol());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);	
	}

}
