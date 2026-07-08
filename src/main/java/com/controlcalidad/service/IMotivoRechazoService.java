package com.controlcalidad.service;

import com.controlcalidad.model.MotivoRechazo;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMotivoRechazoService {
    MotivoRechazo save(MotivoRechazo entity) throws Exception;
    MotivoRechazo update(MotivoRechazo entity, Integer id) throws Exception;
    List<MotivoRechazo> findAll() throws Exception;
    Page<MotivoRechazo> findAll(Pageable pageable) throws Exception;
    MotivoRechazo findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
