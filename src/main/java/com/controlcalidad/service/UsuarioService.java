package com.controlcalidad.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.controlcalidad.model.Usuario;
import com.controlcalidad.repository.IUsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {
	private final IUsuarioRepository repo;
	
	@Override
	public Usuario save(Usuario usuario) throws Exception {
		return repo.save(usuario);
	}

	@Override
	public Usuario update(Usuario usuario, Integer id) throws Exception {
		// TODO Logica utilizando ID
		usuario.setIdUsuario(id);
		return repo.save(usuario);
	}

	@Override
	public List<Usuario> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public Usuario findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new Usuario());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);	
	}

}
