package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.Lote;
import com.controlcalidad.repository.ILoteRepository;

/**
 * Implementación del servicio para Lote.
 * Extiende GenericServiceImpl<Lote, Integer, ILoteRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class LoteService
        extends GenericServiceImpl<Lote, Integer, ILoteRepository>
        implements ILoteService {

    public LoteService(ILoteRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad Lote
     * durante la operación update().
     */
    @Override
    protected void setId(Lote entity, Integer id) {
        entity.setIdLote(id);
    }
}
