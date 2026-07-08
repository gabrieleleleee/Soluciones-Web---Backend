package com.controlcalidad.service;

import com.controlcalidad.model.MaquinariaEquipo;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMaquinariaEquipoService {
    MaquinariaEquipo save(MaquinariaEquipo entity) throws Exception;
    MaquinariaEquipo update(MaquinariaEquipo entity, Integer id) throws Exception;
    List<MaquinariaEquipo> findAll() throws Exception;
    Page<MaquinariaEquipo> findAll(Pageable pageable) throws Exception;
    MaquinariaEquipo findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
