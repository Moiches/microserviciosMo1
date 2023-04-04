package com.example.ms1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Carro {
	private String modelo;
	private String marca;
	private Long usuarioId;
}
