package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.MateriaPrima;
import com.controlcalidad.repository.IMateriaPrimaRepository;

/**
 * Implementación del servicio para MateriaPrima.
 * Extiende GenericServiceImpl<MateriaPrima, Integer, IMateriaPrimaRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class MateriaPrimaService
        extends GenericServiceImpl<MateriaPrima, Integer, IMateriaPrimaRepository>
        implements IMateriaPrimaService {

    public MateriaPrimaService(IMateriaPrimaRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad MateriaPrima
     * durante la operación update().
     */
    @Override
    protected void setId(MateriaPrima entity, Integer id) {
        entity.setIdMateriaPrima(id);
    }
}
