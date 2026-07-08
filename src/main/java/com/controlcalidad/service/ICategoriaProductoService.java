package com.controlcalidad.service;

import com.controlcalidad.model.CategoriaProducto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoriaProductoService {
    CategoriaProducto save(CategoriaProducto entity) throws Exception;
    CategoriaProducto update(CategoriaProducto entity, Integer id) throws Exception;
    List<CategoriaProducto> findAll() throws Exception;
    Page<CategoriaProducto> findAll(Pageable pageable) throws Exception;
    CategoriaProducto findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
