package com.controlcalidad.service;

import java.util.List;
import com.controlcalidad.model.CategoriaProducto;

public interface ICategoriaProductoService {
	CategoriaProducto save(CategoriaProducto categoria) throws Exception;
	CategoriaProducto update(CategoriaProducto categoria, Integer id) throws Exception;
	List<CategoriaProducto> findAll() throws Exception;
	CategoriaProducto findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
