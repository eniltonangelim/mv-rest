package com.angelim.mv.repository;

import org.springframework.data.repository.CrudRepository;

import com.angelim.mv.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
