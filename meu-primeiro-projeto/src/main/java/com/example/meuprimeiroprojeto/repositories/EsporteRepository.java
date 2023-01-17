package com.example.meuprimeiroprojeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.meuprimeiroprojeto.entidades.Esporte;

@Repository
public interface EsporteRepository extends JpaRepository<Esporte, Long> {
		
}
