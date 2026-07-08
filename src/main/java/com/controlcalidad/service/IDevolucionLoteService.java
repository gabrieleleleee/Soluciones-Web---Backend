package com.controlcalidad.service;

import com.controlcalidad.model.DevolucionLote;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDevolucionLoteService {
    DevolucionLote save(DevolucionLote entity) throws Exception;
    DevolucionLote update(DevolucionLote entity, Integer id) throws Exception;
    List<DevolucionLote> findAll() throws Exception;
    Page<DevolucionLote> findAll(Pageable pageable) throws Exception;
    DevolucionLote findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
