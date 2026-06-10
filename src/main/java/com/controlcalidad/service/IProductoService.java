package com.controlcalidad.service;

/**
 * Interfaz específica para Producto.
 * Extiende IGenericService<Producto, Integer> para heredar
 * los 5 métodos CRUD sin necesidad de redefinirlos.
 */
public interface IProductoService extends IGenericService<Producto, Integer> {
    // Aquí se pueden agregar métodos específicos de Producto si se necesitan
}
