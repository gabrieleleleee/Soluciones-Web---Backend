package com.controlcalidad.service;

import java.util.List;
import com.controlcalidad.model.Defecto;

public interface IDefectoService {
	Defecto save(Defecto defecto) throws Exception;
	Defecto update(Defecto defecto, Integer id) throws Exception;
	List<Defecto> findAll() throws Exception;
	Defecto findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
