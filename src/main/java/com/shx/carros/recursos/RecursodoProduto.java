package com.shx.carros.recursos;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shx.carros.entidades.Produto;
import com.shx.carros.servico.ServicodoProduto;


@RestController
@RequestMapping(value = "/produtos")
public class RecursodoProduto {
	
	@Autowired
	private ServicodoProduto servico;
	
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll() { 
		List<Produto> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
}
	
