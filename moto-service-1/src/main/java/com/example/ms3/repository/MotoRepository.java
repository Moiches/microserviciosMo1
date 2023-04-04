package com.example.ms3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ms3.entity.Moto;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long>{

	
	public List<Moto> findByUsuarioId(Long usuarioId);
}
