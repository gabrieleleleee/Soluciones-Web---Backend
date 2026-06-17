package com.controlcalidad.service;

import com.controlcalidad.model.Rol;
import java.util.List;

public interface IRolService {
    Rol save(Rol entity) throws Exception;
    Rol update(Rol entity, Integer id) throws Exception;
    List<Rol> findAll() throws Exception;
    Rol findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
