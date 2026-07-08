package com.controlcalidad.service;

import com.controlcalidad.model.MateriaPrima;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMateriaPrimaService {
    MateriaPrima save(MateriaPrima entity) throws Exception;
    MateriaPrima update(MateriaPrima entity, Integer id) throws Exception;
    List<MateriaPrima> findAll() throws Exception;
    Page<MateriaPrima> findAll(Pageable pageable) throws Exception;
    MateriaPrima findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
