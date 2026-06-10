package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.MaquinariaEquipo;
import com.controlcalidad.repository.IMaquinariaEquipoRepository;

/**
 * Implementación del servicio para MaquinariaEquipo.
 * Extiende GenericServiceImpl<MaquinariaEquipo, Integer, IMaquinariaEquipoRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class MaquinariaEquipoService
        extends GenericServiceImpl<MaquinariaEquipo, Integer, IMaquinariaEquipoRepository>
        implements IMaquinariaEquipoService {

    public MaquinariaEquipoService(IMaquinariaEquipoRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad MaquinariaEquipo
     * durante la operación update().
     */
    @Override
    protected void setId(MaquinariaEquipo entity, Integer id) {
        entity.setIdEquipo(id);
    }
}
