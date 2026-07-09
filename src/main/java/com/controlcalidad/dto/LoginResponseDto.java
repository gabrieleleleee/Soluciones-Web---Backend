package com.controlcalidad.dto;

import java.util.List;

public class LoginResponseDto {
    private String token;
    private String nombreUsuario;
    private String nombreCompleto;
    private List<String> roles;
    private List<Integer> idsRoles;

    public LoginResponseDto(String token, String nombreUsuario,
                            String nombreCompleto, List<String> roles,
                            List<Integer> idsRoles) {
        this.token = token;
        this.nombreUsuario = nombreUsuario;
        this.nombreCompleto = nombreCompleto;
        this.roles = roles;
        this.idsRoles = idsRoles;
    }
    public String getToken() { return token; }
    public String getNombreUsuario() { return nombreUsuario; }
    public String getNombreCompleto() { return nombreCompleto; }
    public List<String> getRoles() { return roles; }
    public List<Integer> getIdsRoles() { return idsRoles; }
}
