package com.github.lucasdevrj.longametragem.dao;

import java.util.List;

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
	
	public void atualizar(Ator ator) {
		this.gerenciador.merge(ator); //Passa do estado Detached para Managed 
	}
	
	public void remover(Ator ator) {
		ator = gerenciador.merge(ator);
		this.gerenciador.remove(ator); //Remove a entidade
	}
	
	public Ator buscarId(int id) {
		return gerenciador.find(Ator.class, id); //buscar entidade do banco
	}
	
	//Para buscar todas entidades do banco
	public List<Ator> buscarTodas() {
		String jpql = "SELECT a FROM Ator a";
		return gerenciador.createQuery(jpql, Ator.class).getResultList();
	}
}
