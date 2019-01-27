package com.angelim.mv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Setter @Getter
public class Telefone {

	@Id
	@GeneratedValue
	private Long id;
	private String ddd;
	private String numero;
	
}
