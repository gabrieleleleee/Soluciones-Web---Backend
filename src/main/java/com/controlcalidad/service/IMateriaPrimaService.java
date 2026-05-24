package com.controlcalidad.service;

import java.util.List;
import com.controlcalidad.model.MateriaPrima;

public interface IMateriaPrimaService {
	MateriaPrima save(MateriaPrima materiaPrima) throws Exception;
	MateriaPrima update(MateriaPrima materiaPrima, Integer id) throws Exception;
	List<MateriaPrima> findAll() throws Exception;
	MateriaPrima findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
