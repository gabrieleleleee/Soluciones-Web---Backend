package com.controlcalidad.service;

import java.util.List;
import com.controlcalidad.model.Inspeccion;

public interface IInspeccionService {
	Inspeccion save(Inspeccion inspeccion) throws Exception;
	Inspeccion update(Inspeccion inspeccion, Integer id) throws Exception;
	List<Inspeccion> findAll() throws Exception;
	Inspeccion findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
