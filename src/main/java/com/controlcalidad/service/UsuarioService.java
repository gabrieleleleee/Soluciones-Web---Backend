package com.controlcalidad.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.controlcalidad.model.Usuario;
import com.controlcalidad.repository.IUsuarioRepository;

@Service
public class UsuarioService
        extends GenericServiceImpl<Usuario, Integer, IUsuarioRepository>
        implements IUsuarioService {

    private final PasswordEncoder passwordEncoder;

    public UsuarioService(IUsuarioRepository repository,
                          PasswordEncoder passwordEncoder) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void setId(Usuario entity, Integer id) {
        entity.setIdUsuario(id);
    }

    @Override
    public Usuario save(Usuario entity) throws Exception {
        entity.setContrasena(passwordEncoder.encode(entity.getContrasena()));
        return repository.save(entity);
    }

    @Override
    public Usuario update(Usuario entity, Integer id) throws Exception {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Registro con id " + id + " no encontrado");
        }
        setId(entity, id);
        // Solo re-hashear si la contraseña no es ya un hash BCrypt
        if (!entity.getContrasena().startsWith("$2a$")) {
            entity.setContrasena(passwordEncoder.encode(entity.getContrasena()));
        }
        return repository.save(entity);
    }
}
