package com.shx.carros.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shx.carros.entidades.Categoria;

public interface RepositoriodaCategoria extends JpaRepository<Categoria, Long> {
	

}
