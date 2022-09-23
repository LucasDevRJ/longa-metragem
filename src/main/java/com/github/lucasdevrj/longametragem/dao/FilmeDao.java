package com.github.lucasdevrj.longametragem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.longametragem.modelo.Filme;
//Classe para fazer a ligaçãot  com o Banco de Dados
public class FilmeDao {

	private EntityManager gerenciador; //pois todos atributos terão EntityManager
	
	public FilmeDao(EntityManager gerenciador) {
		this.gerenciador = gerenciador;
	}
	
	public void cadastrar(Filme filme) {
		this.gerenciador.persist(filme); //para inserir registros
	}
	
	public void atualizar(Filme filme) {
		this.gerenciador.merge(filme); //Passa do estado Detached para Managed 
	}
	
	public void remover(Filme filme) {
		filme = gerenciador.merge(filme);
		this.gerenciador.remove(filme); //Remove a entidade
	}
	
	public Filme buscarId(int id) {
		return gerenciador.find(Filme.class, id); //buscar entidade do banco
	}
	
	//Para buscar todas entidades do banco
	public List<Filme> buscarTodas() {
		String jpql = "SELECT f FROM Filme f";
		return gerenciador.createQuery(jpql, Filme.class).getResultList();
	}
}
