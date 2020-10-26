package com.shx.carros.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shx.carros.entidades.Categoria;
import com.shx.carros.repositorios.RepositoriodaCategoria;

@Service
public class ServicodaCategoria {
	
	@Autowired
	private RepositoriodaCategoria repositorio;
	
	public List<Categoria> findAll(){
		return repositorio.findAll();
	}

	public Categoria findById(Long id) {
		Optional<Categoria> obj = repositorio.findById(id); 
		return obj.get();
	}
}
