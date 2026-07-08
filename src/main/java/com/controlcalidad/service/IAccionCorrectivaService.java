package com.controlcalidad.service;

import com.controlcalidad.model.AccionCorrectiva;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAccionCorrectivaService {
    AccionCorrectiva save(AccionCorrectiva entity) throws Exception;
    AccionCorrectiva update(AccionCorrectiva entity, Integer id) throws Exception;
    List<AccionCorrectiva> findAll() throws Exception;
    Page<AccionCorrectiva> findAll(Pageable pageable) throws Exception;
    AccionCorrectiva findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
