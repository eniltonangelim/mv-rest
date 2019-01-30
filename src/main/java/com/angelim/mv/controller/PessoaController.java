package com.angelim.mv.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.angelim.mv.model.Pessoa;
import com.angelim.mv.service.PessoaService;

import ch.qos.logback.classic.net.SyslogAppender;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/pessoa", produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoaBody) {
		return ResponseEntity.ok(pessoaService.save(pessoaBody));		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Pessoa>> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(pessoaService.findById(id));		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<Pessoa>> findAll() {
		return ResponseEntity.ok().body(pessoaService.findAll());
	}
	
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Pessoa> delete(@PathVariable("id") Long id){
        pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoaBody, @PathVariable Long id) {
    	System.out.println(pessoaBody.getNome());
    	return ResponseEntity.ok(
    			pessoaService.save(
    					pessoaService.findById(id)
    						.map(pessoa -> {
    							pessoa.setNome(pessoaBody.getNome());
    							pessoa.setCpf(pessoaBody.getCpf());
    							pessoa.setEmail(pessoaBody.getEmail());
    							pessoa.setDataNascimento(pessoaBody.getDataNascimento());
    							pessoa.setTelefones(pessoaBody.getTelefones());
    							return pessoa;
    						}).orElseGet(() -> {
    							return this.pessoaService.save(pessoaBody);
    						})
    					));
    }
}
