package com.angelim.mv.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Setter @Getter
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private String email;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	@OrderColumn(name="id")
	private Telefone[] telefones;
	
}
