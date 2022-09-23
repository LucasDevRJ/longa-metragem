package com.github.lucasdevrj.longametragem.dao;

import java.util.List;

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
	
	public Elenco buscarId(int id) {
		return gerenciador.find(Elenco.class, id); //buscar entidade do banco
	}
	
	//Para buscar todas entidades do banco
	public List<Elenco> buscarTodas() {
		String jpql = "SELECT e FROM Elenco e";
		return gerenciador.createQuery(jpql, Elenco.class).getResultList();
	}
}
