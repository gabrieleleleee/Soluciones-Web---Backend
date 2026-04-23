package com.controlcalidad.service;

import java.util.List;

import com.controlcalidad.model.Lote;

public interface ILoteService {
	Lote save(Lote lote) throws Exception;
	Lote update(Lote lote, Integer id) throws Exception;
	List<Lote> findAll() throws Exception;
	Lote findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
