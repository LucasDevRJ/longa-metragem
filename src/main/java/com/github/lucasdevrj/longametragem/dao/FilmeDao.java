package com.github.lucasdevrj.longametragem.dao;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.longametragem.modelo.Elenco;
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
}
