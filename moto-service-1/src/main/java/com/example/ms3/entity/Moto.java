package com.example.ms3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "moto")
public class Moto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "moto_seq_id")
	@SequenceGenerator(name = "moto_seq_id",sequenceName = "moto_seq_id" ,allocationSize = 1)
	private Long id;
	@Column(name="modelo")
	private String modelo;
	@Column(name="marca")
	private String marca;
	@Column(name="usuarioId")
	private Long usuarioId;
	
}
