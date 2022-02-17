package com.example.demo.rest.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.entity.Cliente;
import com.example.demo.model.repository.ClienteRepository;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(@RequestBody Cliente cliente) {
		cliente.setDataCadastro();
		return repository.save(cliente);
	}

	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public Cliente buscarClientePorId(@PathVariable Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluirCliente(@PathVariable Integer id) {
		repository.findById(id).map(cliente -> {
			repository.delete(cliente);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@PatchMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public Cliente atualizarCliente(@RequestBody Cliente clienteAtualizado, @PathVariable Integer id) {
		return repository.findById(id).map(cliente -> {
			cliente.setNome(clienteAtualizado.getNome());
			cliente.setCpf(clienteAtualizado.getCpf());
			return repository.save(cliente);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
