package com.github.lucasdevrj.longametragem.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //Indica que a classe é uma entidade da JPA, ou seja, tem uma tabela no banco a representando
@Table(name = "elenco") //Nome da tabela do banco
public class Ator {
	
	@Id //Para mostrar o atributo id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // para mostrar como o valor é gerado
	private int id;
	private String nome;
	private String sobrenome;
	private String biografia;
	private Date nascimento;
	private double altura;
	private String nacionalidade;
	@ManyToOne
	private Elenco elenco;
	
	public Ator() {
		
	}
	
	public Ator(String nome, String sobrenome, String biografia, Date nascimento, double altura, String nacionalidade) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.biografia = biografia;
		this.nascimento = nascimento;
		this.altura = altura;
		this.nacionalidade = nacionalidade;
	}
}
