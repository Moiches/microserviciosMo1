package com.example.ms1.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms1.entity.User;
import com.example.ms1.models.Carro;
import com.example.ms1.models.Moto;
import com.example.ms1.services.UserService;

@RestController
@RequestMapping("/api/v1/User")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<List<User>>((List<User>) userService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<User> getById(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<User>(userService.getById(id), HttpStatus.OK);
	}

	@GetMapping("/carros/{usuarioId}")
	public ResponseEntity<Carro> getCarrosByUser(@PathVariable(name = "usuarioId") Long usuarioId) {
//		userService.getCarrosByUser(usuarioId);
		return new ResponseEntity<Carro>((Carro) userService.getCarrosByUser(usuarioId), HttpStatus.OK);
	}

	@GetMapping("/motos/{usuarioId}")
	public ResponseEntity<Moto> getMotosByUser(@PathVariable(name = "usuarioId") Long usuarioId) {
//		userService.getCarrosByUser(usuarioId);
		return new ResponseEntity<Moto>((Moto) userService.getMotosByUser(usuarioId), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
	}

	@PostMapping("/carro/{usuarioId}")

	public ResponseEntity<Carro> guardarCarro(@PathVariable("usuarioId") Long usuarioId, @RequestBody Carro carro) {
		return new ResponseEntity<Carro>(userService.saveCarro(usuarioId, carro), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteAllUsers() {
		userService.deleteUser();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) {
		userService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	// metodos del Feign client
	@PostMapping("/carros/{usuarioId}")

	public Carro guardarCarro(@RequestBody Carro carro, @PathVariable(name = "usuarioId") Long usuarioId) {
		Carro saveCarro = userService.saveCarro(usuarioId, carro);
		return saveCarro;

	}
	@PostMapping("/motos/{usuarioId}")

	public Moto guardarMoto(@RequestBody Moto moto, @PathVariable(name = "usuarioId") Long usuarioId) {
		Moto saveMoto = userService.saveMoto(usuarioId, moto);
		return saveMoto;

	}
	
	
	@GetMapping("/todos/{usuarioId}")
	
	public ResponseEntity<Map<String, Object>> getCarsAndMotosPerUser(@PathVariable(name = "usuarioId") Long usuarioId){
		return new ResponseEntity<>(userService.getUsuarioAndVehiculo(usuarioId), HttpStatus.OK);
	}
	

}
