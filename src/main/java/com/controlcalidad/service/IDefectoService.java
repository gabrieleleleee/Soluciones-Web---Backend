package com.controlcalidad.service;

import com.controlcalidad.model.Defecto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDefectoService {
    Defecto save(Defecto entity) throws Exception;
    Defecto update(Defecto entity, Integer id) throws Exception;
    List<Defecto> findAll() throws Exception;
    Page<Defecto> findAll(Pageable pageable) throws Exception;
    Defecto findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
