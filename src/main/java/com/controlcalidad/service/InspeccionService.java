package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.Inspeccion;
import com.controlcalidad.repository.IInspeccionRepository;

/**
 * Implementación del servicio para Inspeccion.
 * Extiende GenericServiceImpl<Inspeccion, Integer, IInspeccionRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class InspeccionService
        extends GenericServiceImpl<Inspeccion, Integer, IInspeccionRepository>
        implements IInspeccionService {

    public InspeccionService(IInspeccionRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad Inspeccion
     * durante la operación update().
     */
    @Override
    protected void setId(Inspeccion entity, Integer id) {
        entity.setIdInspeccion(id);
    }
}
