package com.controlcalidad.service;

import com.controlcalidad.model.Permiso;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPermisoService {
    Permiso save(Permiso entity) throws Exception;
    Permiso update(Permiso entity, Integer id) throws Exception;
    List<Permiso> findAll() throws Exception;
    Page<Permiso> findAll(Pageable pageable) throws Exception;
    Permiso findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
