package com.shx.carros.recursos;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shx.carros.entidades.Ordem;
import com.shx.carros.servico.ServicodaOrdem;


@RestController
@RequestMapping(value = "/ordens")
public class RecursodaOrdem {
	
	@Autowired
	private ServicodaOrdem servico;
	
	
	@GetMapping
	public ResponseEntity<List<Ordem>> findAll() { 
		List<Ordem> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Ordem> findById(@PathVariable Long id){
		Ordem obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
}
	
