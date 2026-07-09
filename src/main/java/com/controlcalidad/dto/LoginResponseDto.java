package com.controlcalidad.dto;

import java.util.List;

public class LoginResponseDto {
    private String token;
    private String nombreUsuario;
    private String nombreCompleto;
    private List<String> roles;
    private List<Integer> idsRoles;
    private List<String> modulos;

    public LoginResponseDto(String token, String nombreUsuario,
                            String nombreCompleto, List<String> roles,
                            List<Integer> idsRoles, List<String> modulos) {
        this.token = token;
        this.nombreUsuario = nombreUsuario;
        this.nombreCompleto = nombreCompleto;
        this.roles = roles;
        this.idsRoles = idsRoles;
        this.modulos = modulos;
    }
    public String getToken() { return token; }
    public String getNombreUsuario() { return nombreUsuario; }
    public String getNombreCompleto() { return nombreCompleto; }
    public List<String> getRoles() { return roles; }
    public List<Integer> getIdsRoles() { return idsRoles; }
    public List<String> getModulos() { return modulos; }
}
