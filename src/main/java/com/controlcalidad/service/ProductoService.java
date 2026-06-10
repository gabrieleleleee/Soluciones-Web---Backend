package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.Producto;
import com.controlcalidad.repository.IProductoRepository;

/**
 * Implementación del servicio para Producto.
 * Extiende GenericServiceImpl<Producto, Integer, IProductoRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class ProductoService
        extends GenericServiceImpl<Producto, Integer, IProductoRepository>
        implements IProductoService {

    public ProductoService(IProductoRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad Producto
     * durante la operación update().
     */
    @Override
    protected void setId(Producto entity, Integer id) {
        entity.setIdProducto(id);
    }
}
