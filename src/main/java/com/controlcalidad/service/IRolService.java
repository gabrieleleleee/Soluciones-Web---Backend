package com.controlcalidad.service;

import com.controlcalidad.model.Rol;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRolService {
    Rol save(Rol entity) throws Exception;
    Rol update(Rol entity, Integer id) throws Exception;
    List<Rol> findAll() throws Exception;
    Page<Rol> findAll(Pageable pageable) throws Exception;
    Rol findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
