package com.controlcalidad.service;

import com.controlcalidad.model.CategoriaProducto;
import java.util.List;

public interface ICategoriaProductoService {
    CategoriaProducto save(CategoriaProducto entity) throws Exception;
    CategoriaProducto update(CategoriaProducto entity, Integer id) throws Exception;
    List<CategoriaProducto> findAll() throws Exception;
    CategoriaProducto findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
