package com.shx.carros.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shx.carros.entidades.Usuario;

public interface RepositoriodoUsuario extends JpaRepository<Usuario, Long> {
	

}
