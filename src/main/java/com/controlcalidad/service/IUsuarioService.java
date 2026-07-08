package com.controlcalidad.service;

import com.controlcalidad.model.Usuario;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUsuarioService {
    Usuario save(Usuario entity) throws Exception;
    Usuario update(Usuario entity, Integer id) throws Exception;
    List<Usuario> findAll() throws Exception;
    Page<Usuario> findAll(Pageable pageable) throws Exception;
    Usuario findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
