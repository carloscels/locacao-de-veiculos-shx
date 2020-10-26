package com.shx.carros.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shx.carros.entidades.Produto;

public interface RepositoriodoProduto extends JpaRepository<Produto, Long> {
	

}
