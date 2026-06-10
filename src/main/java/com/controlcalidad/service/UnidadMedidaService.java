package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.UnidadMedida;
import com.controlcalidad.repository.IUnidadMedidaRepository;

/**
 * Implementación del servicio para UnidadMedida.
 * Extiende GenericServiceImpl<UnidadMedida, Integer, IUnidadMedidaRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class UnidadMedidaService
        extends GenericServiceImpl<UnidadMedida, Integer, IUnidadMedidaRepository>
        implements IUnidadMedidaService {

    public UnidadMedidaService(IUnidadMedidaRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad UnidadMedida
     * durante la operación update().
     */
    @Override
    protected void setId(UnidadMedida entity, Integer id) {
        entity.setIdUnidad(id);
    }
}
