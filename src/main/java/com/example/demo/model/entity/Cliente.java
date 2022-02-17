package com.example.demo.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;

	public Cliente() {
		super();
		this.dataCadastro = LocalDate.now();
	}

	public Cliente(Integer id, String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataCadastro = LocalDate.now();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro() {
		this.dataCadastro = LocalDate.now();
	}

}
