package com.controlcalidad.service;

/**
 * Interfaz específica para Usuario.
 * Extiende IGenericService<Usuario, Integer> para heredar
 * los 5 métodos CRUD sin necesidad de redefinirlos.
 */
public interface IUsuarioService extends IGenericService<Usuario, Integer> {
    // Aquí se pueden agregar métodos específicos de Usuario si se necesitan
}
