package com.shx.carros.recursos;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shx.carros.entidades.Categoria;
import com.shx.carros.servico.ServicodaCategoria;


@RestController
@RequestMapping(value = "/categorias")
public class RecursodaCategoria {
	
	@Autowired
	private ServicodaCategoria servico;
	
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() { 
		List<Categoria> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		Categoria obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
}
	
