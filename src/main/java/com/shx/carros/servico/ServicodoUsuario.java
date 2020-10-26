package com.shx.carros.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shx.carros.entidades.Usuario;
import com.shx.carros.repositorios.RepositoriodoUsuario;

@Service
public class ServicodoUsuario {
	
	@Autowired
	private RepositoriodoUsuario repositorio;
	
	public List<Usuario> findAll(){
		return repositorio.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj = repositorio.findById(id); 
		return obj.get();
	}
	
	public Usuario insert(Usuario obj) {
		return repositorio.save(obj);
	}

	public void delete(Long id) {
		repositorio.deleteById(id);	
	}
	
	public Usuario update(Long id, Usuario obj) {
		Usuario entity = repositorio.getOne(id);
		updateData (entity , obj);
		return repositorio.save(entity);
	}

	private void updateData(Usuario entity, Usuario obj) {
		entity.setNome(obj.getNome());
		entity.setCpf(obj.getCpf());
		entity.setNascimento(obj.getNascimento());
		
	}
	
}
