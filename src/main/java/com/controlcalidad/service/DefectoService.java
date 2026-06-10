package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.Defecto;
import com.controlcalidad.repository.IDefectoRepository;

/**
 * Implementación del servicio para Defecto.
 * Extiende GenericServiceImpl<Defecto, Integer, IDefectoRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class DefectoService
        extends GenericServiceImpl<Defecto, Integer, IDefectoRepository>
        implements IDefectoService {

    public DefectoService(IDefectoRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad Defecto
     * durante la operación update().
     */
    @Override
    protected void setId(Defecto entity, Integer id) {
        entity.setIdDefecto(id);
    }
}
