package com.controlcalidad.service;

import java.util.List;

import com.controlcalidad.model.Producto;

public interface IProductoService {
	Producto save(Producto producto) throws Exception;
	Producto update(Producto producto, Integer id) throws Exception;
	List<Producto> findAll() throws Exception;
	Producto findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
