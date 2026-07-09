package com.controlcalidad.service;

import com.controlcalidad.dto.LoginRequestDto;
import com.controlcalidad.dto.LoginResponseDto;
import com.controlcalidad.model.Usuario;
import com.controlcalidad.repository.IUsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio de autenticacion.
 * Verifica las credenciales y genera el JWT de respuesta.
 */
@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final IUsuarioRepository usuarioRepository;

    public AuthService(AuthenticationManager authenticationManager,
                       UserDetailsService userDetailsService,
                       JwtService jwtService,
                       IUsuarioRepository usuarioRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
    }

    public LoginResponseDto login(LoginRequestDto request) {
        // Verifica credenciales - lanza excepcion si son incorrectas
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getNombreUsuario(),
                        request.getContrasena()));

        UserDetails userDetails = userDetailsService
                .loadUserByUsername(request.getNombreUsuario());
        String token = jwtService.generateToken(userDetails);

        Usuario usuario = usuarioRepository
                .findByNombreUsuario(request.getNombreUsuario()).orElseThrow();

        List<String> roles = usuario.getRoles().stream()
                .map(rol -> rol.getNombre())
                .collect(Collectors.toList());

        List<Integer> idsRoles = usuario.getRoles().stream()
                .map(rol -> rol.getIdRol())
                .collect(Collectors.toList());

        return new LoginResponseDto(token, usuario.getNombreUsuario(),
                                    usuario.getNombreCompleto(), roles, idsRoles);
    }
}
