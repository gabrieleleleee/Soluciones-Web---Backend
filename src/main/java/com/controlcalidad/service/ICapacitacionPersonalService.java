package com.controlcalidad.service;

import java.util.List;
import com.controlcalidad.model.CapacitacionPersonal;

public interface ICapacitacionPersonalService {
	CapacitacionPersonal save(CapacitacionPersonal capacitacion) throws Exception;
	CapacitacionPersonal update(CapacitacionPersonal capacitacion, Integer id) throws Exception;
	List<CapacitacionPersonal> findAll() throws Exception;
	CapacitacionPersonal findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
