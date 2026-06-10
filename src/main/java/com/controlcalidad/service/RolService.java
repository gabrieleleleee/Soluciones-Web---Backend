package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.Rol;
import com.controlcalidad.repository.IRolRepository;

/**
 * Implementación del servicio para Rol.
 * Extiende GenericServiceImpl<Rol, Integer, IRolRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class RolService
        extends GenericServiceImpl<Rol, Integer, IRolRepository>
        implements IRolService {

    public RolService(IRolRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad Rol
     * durante la operación update().
     */
    @Override
    protected void setId(Rol entity, Integer id) {
        entity.setIdRol(id);
    }
}
