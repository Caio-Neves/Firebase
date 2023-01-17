package com.example.meuprimeiroprojeto.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.meuprimeiroprojeto.entidades.Esporte;
import com.example.meuprimeiroprojeto.repositories.EsporteRepository;

@RestController
@RequestMapping(value = "/esportes")
public class EsporteResource {

	//Faz a conexão com a outra classe sem precisar ficar criando novo objeto e resetar a outra classe.
	@Autowired
	private EsporteRepository esporteRepository;

	@GetMapping
	public ResponseEntity<List<Esporte>> findAll(){
		
		List<Esporte> list = esporteRepository.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Esporte> findById(@PathVariable Long id){
		Esporte esporte = esporteRepository.findById(id).get();
		return ResponseEntity.ok().body(esporte);
	}
	
}
