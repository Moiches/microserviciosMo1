package com.example.ms3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms3.entity.Moto;
import com.example.ms3.repository.MotoRepository;

@Service
public class MotoService {

	@Autowired
	private MotoRepository motoRepository;
	
	public List<Moto> getAll() {
		return motoRepository.findAll();
	}

	public Moto getById(Long id) {

		return motoRepository.findById(id).orElse(null);
	}

	public List<Moto> getByUserId(Long usuarioId){
		return motoRepository.findByUsuarioId(usuarioId);
	}
	
	public Moto save(Moto moto) {
		Moto save = motoRepository.save(moto);
		return save;
	}

	public void deleteMoto() {
		motoRepository.deleteAll();
	}

	public void deleteById(Long id) {

		motoRepository.deleteById(id);

	}
	
	
}