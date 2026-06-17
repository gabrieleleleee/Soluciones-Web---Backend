package com.controlcalidad.controller;

import com.controlcalidad.dto.LoginRequestDto;
import com.controlcalidad.dto.LoginResponseDto;
import com.controlcalidad.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador publico de autenticacion.
 * POST /auth/login: no requiere token JWT.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @Valid @RequestBody LoginRequestDto request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
