package com.controlcalidad.dto;
import java.util.List;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class UsuarioDto {
	@NotBlank(message = "El nombre de usuario es obligatorio")
	@Size(max = 70)
	private String nombreUsuario;
	@NotBlank(message = "La contrasena es obligatoria")
	@Size(min = 4, max = 100)
	private String contrasena;
	@NotBlank(message = "El nombre completo es obligatorio")
	@Size(max = 100)
	private String nombreCompleto;
	@NotBlank(message = "El correo es obligatorio")
	@Email(message = "Formato de correo invalido")
	private String correo;
	private boolean activo;
	private List<Integer> idsRoles;
	public String getNombreUsuario() { return nombreUsuario; }
	public void setNombreUsuario(String v) { this.nombreUsuario = v; }
	public String getContrasena() { return contrasena; }
	public void setContrasena(String v) { this.contrasena = v; }
	public String getNombreCompleto() { return nombreCompleto; }
	public void setNombreCompleto(String v) { this.nombreCompleto = v; }
	public String getCorreo() { return correo; }
	public void setCorreo(String v) { this.correo = v; }
	public boolean isActivo() { return activo; }
	public void setActivo(boolean v) { this.activo = v; }
	public List<Integer> getIdsRoles() { return idsRoles; }
	public void setIdsRoles(List<Integer> v) { this.idsRoles = v; }
}