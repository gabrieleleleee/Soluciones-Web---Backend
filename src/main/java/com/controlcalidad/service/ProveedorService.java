package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.Proveedor;
import com.controlcalidad.repository.IProveedorRepository;

/**
 * Implementación del servicio para Proveedor.
 * Extiende GenericServiceImpl<Proveedor, Integer, IProveedorRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class ProveedorService
        extends GenericServiceImpl<Proveedor, Integer, IProveedorRepository>
        implements IProveedorService {

    public ProveedorService(IProveedorRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad Proveedor
     * durante la operación update().
     */
    @Override
    protected void setId(Proveedor entity, Integer id) {
        entity.setIdProveedor(id);
    }
}
