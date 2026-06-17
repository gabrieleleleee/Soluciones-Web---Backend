package com.controlcalidad.repository;

import com.controlcalidad.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repository de Usuario.
 * Agrega findByNombreUsuario para que Spring Security
 * pueda cargar el usuario al autenticar.
 */
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}
