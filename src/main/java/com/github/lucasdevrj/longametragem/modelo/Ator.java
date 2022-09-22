package com.github.lucasdevrj.longametragem.modelo;

import java.util.Date;

public class Ator {
	
	private int id;
	private String nome;
	private String sobrenome;
	private String biografia;
	private Date nascimento;
	private double altura;
	private String nacionalidade;
	
	public Ator(String nome, String sobrenome, String biografia, Date nascimento, double altura, String nacionalidade) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.biografia = biografia;
		this.nascimento = nascimento;
		this.altura = altura;
		this.nacionalidade = nacionalidade;
	}
}
