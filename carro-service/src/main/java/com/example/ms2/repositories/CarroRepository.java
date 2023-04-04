package com.example.ms2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ms2.entity.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{

	public List<Carro> findByUsuarioId(Long usuarioId);
	
}
