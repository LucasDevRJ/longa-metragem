package com.github.lucasdevrj.longametragem.dao;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.longametragem.modelo.Elenco;
//Classe para fazer a liga��ot  com o Banco de Dados
public class ElencoDao {

	private EntityManager gerenciador; //pois todos atributos ter�o EntityManager
	
	public ElencoDao(EntityManager gerenciador) {
		this.gerenciador = gerenciador;
	}
	
	public void cadastrar(Elenco elenco) {
		this.gerenciador.persist(elenco); //para inserir registros
	}
	
}
