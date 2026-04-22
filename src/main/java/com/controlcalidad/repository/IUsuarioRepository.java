package com.controlcalidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlcalidad.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

}
