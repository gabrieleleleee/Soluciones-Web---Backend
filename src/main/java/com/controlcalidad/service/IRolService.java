package com.controlcalidad.service;

import java.util.List;

import com.controlcalidad.model.Rol;

public interface IRolService {
	Rol save(Rol rol) throws Exception;
	Rol update(Rol rol, Integer id) throws Exception;
	List<Rol> findAll() throws Exception;
	Rol findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
