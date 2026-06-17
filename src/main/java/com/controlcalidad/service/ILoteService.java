package com.controlcalidad.service;

import com.controlcalidad.model.Lote;
import java.util.List;

public interface ILoteService {
    Lote save(Lote entity) throws Exception;
    Lote update(Lote entity, Integer id) throws Exception;
    List<Lote> findAll() throws Exception;
    Lote findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
