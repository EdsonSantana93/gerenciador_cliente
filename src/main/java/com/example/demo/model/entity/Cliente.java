package com.example.demo.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome", nullable = false, length = 180)
	private String nome;

	@Column(name = "cpf", nullable = false)
	private String cpf;

	@Column(name = "data_cadastro")
	private LocalDate dataCadastro;
}
