package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.Permiso;
import com.controlcalidad.repository.IPermisoRepository;

/**
 * Implementación del servicio para Permiso.
 * Extiende GenericServiceImpl<Permiso, Integer, IPermisoRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class PermisoService
        extends GenericServiceImpl<Permiso, Integer, IPermisoRepository>
        implements IPermisoService {

    public PermisoService(IPermisoRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad Permiso
     * durante la operación update().
     */
    @Override
    protected void setId(Permiso entity, Integer id) {
        entity.setIdPermiso(id);
    }
}
