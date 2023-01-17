package com.example.meuprimeiroprojeto.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.meuprimeiroprojeto.entidades.Categoria;
import com.example.meuprimeiroprojeto.repositories.CategoriaRepository;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	//Faz a conexão com a outra classe sem precisar ficar criando novo objeto e resetar a outra classe.
	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(){
		
		List<Categoria> list = categoriaRepository.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		
		Categoria categoria = categoriaRepository.findById(id).get();
		
		return ResponseEntity.ok().body(categoria);
	}
}
