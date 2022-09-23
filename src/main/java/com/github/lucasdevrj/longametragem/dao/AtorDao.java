package com.github.lucasdevrj.longametragem.dao;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.longametragem.modelo.Ator;
//Classe para fazer a ligaçãot  com o Banco de Dados
public class AtorDao {

	private EntityManager gerenciador; //pois todos atributos terão EntityManager
	
	public AtorDao(EntityManager gerenciador) {
		this.gerenciador = gerenciador;
	}
	
	public void cadastrar(Ator ator) {
		this.gerenciador.persist(ator); //para inserir registros
	}
	
}
