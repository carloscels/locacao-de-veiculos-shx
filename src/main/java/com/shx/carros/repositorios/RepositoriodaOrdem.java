package com.shx.carros.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shx.carros.entidades.Ordem;

public interface RepositoriodaOrdem extends JpaRepository<Ordem, Long> {
	

}
