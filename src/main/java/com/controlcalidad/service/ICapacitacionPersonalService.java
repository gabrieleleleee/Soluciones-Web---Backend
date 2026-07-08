package com.controlcalidad.service;

import com.controlcalidad.model.CapacitacionPersonal;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICapacitacionPersonalService {
    CapacitacionPersonal save(CapacitacionPersonal entity) throws Exception;
    CapacitacionPersonal update(CapacitacionPersonal entity, Integer id) throws Exception;
    List<CapacitacionPersonal> findAll() throws Exception;
    Page<CapacitacionPersonal> findAll(Pageable pageable) throws Exception;
    CapacitacionPersonal findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
