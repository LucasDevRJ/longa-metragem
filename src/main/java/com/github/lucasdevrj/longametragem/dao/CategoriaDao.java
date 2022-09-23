package com.github.lucasdevrj.longametragem.dao;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.longametragem.modelo.Categoria;
//Classe para fazer a ligaçãot  com o Banco de Dados
public class CategoriaDao {

	private EntityManager gerenciador; //pois todos atributos terão EntityManager
	
	public CategoriaDao(EntityManager gerenciador) {
		this.gerenciador = gerenciador;
	}
	
	public void cadastrar(Categoria categoria) {
		this.gerenciador.persist(categoria); //para inserir registros
	}
	
	public void atualizar(Categoria categoria) {
		this.gerenciador.merge(categoria);
	}
	
}
