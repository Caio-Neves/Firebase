package com.example.meuprimeiroprojeto;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.meuprimeiroprojeto.entidades.Categoria;
import com.example.meuprimeiroprojeto.entidades.Esporte;
import com.example.meuprimeiroprojeto.repositories.CategoriaRepository;
import com.example.meuprimeiroprojeto.repositories.EsporteRepository;

@SpringBootApplication
public class MeuPrimeiroProjetoApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepositorio;
	@Autowired EsporteRepository esporteRepository;
	
	public static void main(String[] args) {
		
		SpringApplication.run(MeuPrimeiroProjetoApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null, "Aquático");
		Categoria c2 = new Categoria(null, "Radical");
		Esporte e1 = new Esporte(null, 1, "Skate", c2);
		Esporte e2 = new Esporte(null, 1, "Surf", c1);
		Esporte e3 = new Esporte(null, 1, "Bung Jump", c2);
		Esporte e4 = new Esporte(null, 14, "Polo aquático", c1);
		
		c1.getEsportes().addAll(Arrays.asList(e2,e4));
		c2.getEsportes().addAll(Arrays.asList(e1, e3));
		
		categoriaRepositorio.save(c1);
		categoriaRepositorio.save(c2);
		
		esporteRepository.save(e1);
		esporteRepository.save(e2);
		esporteRepository.save(e3);
		esporteRepository.save(e4);
	}

}
