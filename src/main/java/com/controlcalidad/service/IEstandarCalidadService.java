package com.controlcalidad.service;

import java.util.List;

import com.controlcalidad.model.EstandarCalidad;

public interface IEstandarCalidadService {
	EstandarCalidad save(EstandarCalidad estandar) throws Exception;
	EstandarCalidad update(EstandarCalidad estandar, Integer id) throws Exception;
	List<EstandarCalidad> findAll() throws Exception;
	EstandarCalidad findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
