package com.github.lucasdevrj.longametragem.dao;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.longametragem.modelo.Filme;
//Classe para fazer a liga��o com o Banco de Dados
public class FilmeDao {

	private EntityManager contrutor; //pois todos atributos ter�o EntityManager
	
	public FilmeDao(EntityManager contrutor) {
		this.contrutor = contrutor;
	}
	
	public void cadastrar(Filme filme) {
		this.contrutor.persist(filme); //para inserir registros
	}
	
}
