package com.controlcalidad.service;

import java.util.List;

import com.controlcalidad.model.Usuario;

public interface IUsuarioService {
	Usuario save(Usuario usuario) throws Exception;
	Usuario update(Usuario usuario, Integer id) throws Exception;
	List<Usuario> findAll() throws Exception;
	Usuario findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
