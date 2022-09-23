package com.github.lucasdevrj.longametragem.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity //Indica que a classe é uma entidade da JPA, ou seja, tem uma tabela no banco a representando
@Table(name = "elenco") //Nome da tabela do banco
public class Elenco {

	@Id //Para mostrar o atributo id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // para mostrar como o valor é gerado
	private int id;
	@OneToMany
	private List<Ator> atores;
	
	public Elenco() {
		
	}
	
	public Elenco(List<Ator> atores) {
		this.atores = atores;
	}
}
