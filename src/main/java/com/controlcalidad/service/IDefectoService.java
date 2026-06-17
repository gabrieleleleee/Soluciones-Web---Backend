package com.controlcalidad.service;

import com.controlcalidad.model.Defecto;
import java.util.List;

public interface IDefectoService {
    Defecto save(Defecto entity) throws Exception;
    Defecto update(Defecto entity, Integer id) throws Exception;
    List<Defecto> findAll() throws Exception;
    Defecto findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
