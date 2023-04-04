package com.example.ms1.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ms1.models.Moto;

@FeignClient(name = "moto-service", url = "http://localhost:8081")
@RequestMapping("/api/v1/motos")
public interface MotoFeignClient {

	@PostMapping
	public Moto save(@RequestBody Moto moto);	
	
	@GetMapping("/userId/{usuarioId}")
	public List<Moto> getMotos(@PathVariable(name = "usuarioId") Long usuarioId);
	
	
}
