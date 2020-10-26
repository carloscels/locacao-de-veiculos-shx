package com.shx.carros.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shx.carros.entidades.Ordem;
import com.shx.carros.repositorios.RepositoriodaOrdem;

@Service
public class ServicodaOrdem {
	
	@Autowired
	private RepositoriodaOrdem repositorio;
	
	public List<Ordem> findAll(){
		return repositorio.findAll();
	}

	public Ordem findById(Long id) {
		Optional<Ordem> obj = repositorio.findById(id); 
		return obj.get();
	}
}
