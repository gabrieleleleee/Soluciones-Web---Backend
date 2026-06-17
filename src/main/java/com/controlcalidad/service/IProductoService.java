package com.controlcalidad.service;

import com.controlcalidad.model.Producto;
import java.util.List;

public interface IProductoService {
    Producto save(Producto entity) throws Exception;
    Producto update(Producto entity, Integer id) throws Exception;
    List<Producto> findAll() throws Exception;
    Producto findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
