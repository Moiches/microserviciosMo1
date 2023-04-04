package com.example.ms1.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ms1.entity.User;
import com.example.ms1.feignclients.CarroFeignClient;
import com.example.ms1.feignclients.MotoFeignClient;
import com.example.ms1.models.Carro;
import com.example.ms1.models.Moto;
import com.example.ms1.repository.UserInterface;

@Service
public class UserService {

	@Autowired
	private UserInterface userRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CarroFeignClient carroFeignClient;
	
	@Autowired
	private MotoFeignClient motoFeignClient;
	
	//metodo feign
	public Carro saveCarro(Long usuarioId, Carro carro) {
		carro.setUsuarioId(usuarioId);
		Carro save = carroFeignClient.saveCarro(carro);
		
		return save;
	}
	
	public Moto saveMoto(Long usuarioId, Moto moto) {
		moto.setUsuarioId(usuarioId);
		Moto save = motoFeignClient.save(moto);
		return save;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Carro> getCarrosByUser(Long usuarioId){
		List<Carro> carros = restTemplate.getForObject("http://localhost:8001/api/v1/carros/" + usuarioId, List.class);
		return carros;
	}
	
	@SuppressWarnings("unchecked")
	public List<Moto> getMotosByUser(Long usuarioId){
		List<Moto> motos = restTemplate.getForObject("http://localhost:8081/api/v1/motos/" + usuarioId, List.class);
		return motos;
	}
	
	
	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User getById(Long id) {

		return userRepository.findById(id).orElse(null);
	}

	public User save(User user) {
		User save = userRepository.save(user);
		return save;
	}

	public void deleteUser() {
		userRepository.deleteAll();
	}

	public void deleteById(Long id) {

		userRepository.deleteById(id);

	}

	
	public Map<String, Object> getUsuarioAndVehiculo(Long usuarioId){
		Map<String,Object> resultado = new HashMap<>();
		User user = userRepository.findById(usuarioId).orElse(null);
		
		if(user == null) {
			resultado.put("Mensaje", "El usuario no existe");
			return resultado;
		}
	
		resultado.put("Usuario", user);
		List<Carro> carros = carroFeignClient.getCarros(usuarioId);
		if(carros.isEmpty()) {
			resultado.put("Carros", "El usuario no tiene carros");
			return resultado;
			
		}
		resultado.put("Carros", carros);
		List<Moto> motos = motoFeignClient.getMotos(usuarioId);
		if(motos.isEmpty()) {
			resultado.put("Motos", "El usuario no tiene motos");
			return resultado;
			
		}
		resultado.put("Motos", motos);
		return resultado;
			
	}
	
}
