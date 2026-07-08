package com.controlcalidad.service;

import com.controlcalidad.model.Usuario;
import com.controlcalidad.repository.IUsuarioRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Carga el usuario desde la BD para Spring Security.
 * Convierte los Roles del sistema en GrantedAuthority
 * para que Spring Security pueda manejar los permisos.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final IUsuarioRepository usuarioRepository;

    public CustomUserDetailsService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario)
            throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Usuario no encontrado: " + nombreUsuario));

        List<SimpleGrantedAuthority> authorities = usuario.getRoles().stream()
                .flatMap(rol -> List.of(
                    new SimpleGrantedAuthority("ROLE_" + rol.getNombre().toUpperCase().replace(" ", "_")),
                    new SimpleGrantedAuthority("ROL_ID_" + rol.getIdRol())
                ).stream())
                .collect(Collectors.toList());

        return new User(
                usuario.getNombreUsuario(),
                usuario.getContrasena(),
                usuario.isActivo(),
                true, true, true,
                authorities);
    }
}
