package com.controlcalidad.dto;

import java.util.List;

public class LoginResponseDto {
    private String token;
    private String nombreUsuario;
    private String nombreCompleto;
    private List<String> roles;

    public LoginResponseDto(String token, String nombreUsuario,
                            String nombreCompleto, List<String> roles) {
        this.token = token;
        this.nombreUsuario = nombreUsuario;
        this.nombreCompleto = nombreCompleto;
        this.roles = roles;
    }
    public String getToken() { return token; }
    public String getNombreUsuario() { return nombreUsuario; }
    public String getNombreCompleto() { return nombreCompleto; }
    public List<String> getRoles() { return roles; }
}
