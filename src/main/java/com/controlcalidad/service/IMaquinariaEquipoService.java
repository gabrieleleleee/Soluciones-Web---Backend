package com.controlcalidad.service;

import java.util.List;
import com.controlcalidad.model.MaquinariaEquipo;

public interface IMaquinariaEquipoService {
	MaquinariaEquipo save(MaquinariaEquipo maquinaria) throws Exception;
	MaquinariaEquipo update(MaquinariaEquipo maquinaria, Integer id) throws Exception;
	List<MaquinariaEquipo> findAll() throws Exception;
	MaquinariaEquipo findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
