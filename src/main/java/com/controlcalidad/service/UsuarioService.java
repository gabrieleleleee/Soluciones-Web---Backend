package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.Usuario;
import com.controlcalidad.repository.IUsuarioRepository;

/**
 * Implementación del servicio para Usuario.
 * Extiende GenericServiceImpl<Usuario, Integer, IUsuarioRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class UsuarioService
        extends GenericServiceImpl<Usuario, Integer, IUsuarioRepository>
        implements IUsuarioService {

    public UsuarioService(IUsuarioRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad Usuario
     * durante la operación update().
     */
    @Override
    protected void setId(Usuario entity, Integer id) {
        entity.setIdUsuario(id);
    }
}
