package com.github.lucasdevrj.longametragem.dao;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.longametragem.modelo.Filme;
//Classe para fazer a liga��ot  com o Banco de Dados
public class FilmeDao {

	private EntityManager gerenciador; //pois todos atributos ter�o EntityManager
	
	public FilmeDao(EntityManager gerenciador) {
		this.gerenciador = gerenciador;
	}
	
	public void cadastrar(Filme filme) {
		this.gerenciador.persist(filme); //para inserir registros
	}
	
}
