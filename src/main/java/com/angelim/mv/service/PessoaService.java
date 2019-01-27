package com.angelim.mv.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.angelim.mv.model.Pessoa;
import com.angelim.mv.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa save(@Validated Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public Optional<Pessoa> findById(Long id) {
		return pessoaRepository.findById(id);
	}
	
	public Iterable<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}
	
	public void delete(Long id) {
		pessoaRepository.deleteById(id);
	}
	
}
