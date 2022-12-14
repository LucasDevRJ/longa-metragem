package com.github.lucasdevrj.longametragem.dao;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.longametragem.modelo.Ator;
//Classe para fazer a liga??ot  com o Banco de Dados
public class AtorDao {

	private EntityManager gerenciador; //pois todos atributos ter?o EntityManager
	
	public AtorDao(EntityManager gerenciador) {
		this.gerenciador = gerenciador;
	}
	
	public void cadastrar(Ator ator) {
		this.gerenciador.persist(ator); //para inserir registros
	}
	
	public void atualizar(Ator ator) {
		this.gerenciador.merge(ator); //Passa do estado Detached para Managed 
	}
	
	public void remover(Ator ator) {
		ator = gerenciador.merge(ator);
		this.gerenciador.remove(ator); //Remove a entidade
	}
}
