package com.controlcalidad.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequestDto {
    @NotBlank(message = "El nombre de usuario es obligatorio")
    private String nombreUsuario;
    @NotBlank(message = "La contrasena es obligatoria")
    private String contrasena;
    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String v) { this.nombreUsuario = v; }
    public String getContrasena() { return contrasena; }
    public void setContrasena(String v) { this.contrasena = v; }
}
