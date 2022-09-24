package com.github.lucasdevrj.longametragem.dao;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.longametragem.modelo.Elenco;
//Classe para fazer a ligaçãot  com o Banco de Dados
public class ElencoDao {

	private EntityManager gerenciador; //pois todos atributos terão EntityManager
	
	public ElencoDao(EntityManager gerenciador) {
		this.gerenciador = gerenciador;
	}
	
	public void cadastrar(Elenco elenco) {
		this.gerenciador.persist(elenco); //para inserir registros
	}
	
	public void atualizar(Elenco elenco) {
		this.gerenciador.merge(elenco); //Passa do estado Detached para Managed 
	}
	
	public void remover(Elenco elenco) {
		elenco = gerenciador.merge(elenco);
		this.gerenciador.remove(elenco); //Remove a entidade
	}
}
