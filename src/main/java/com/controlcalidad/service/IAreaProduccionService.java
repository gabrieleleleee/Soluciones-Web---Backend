package com.controlcalidad.service;

import java.util.List;
import com.controlcalidad.model.AreaProduccion;

public interface IAreaProduccionService {
	AreaProduccion save(AreaProduccion areaProduccion) throws Exception;
	AreaProduccion update(AreaProduccion areaProduccion, Integer id) throws Exception;
	List<AreaProduccion> findAll() throws Exception;
	AreaProduccion findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
