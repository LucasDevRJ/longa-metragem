package com.github.lucasdevrj.longametragem.dao;

import java.util.List;

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
		this.gerenciador.merge(categoria); //Passa do estado Detached para Managed 
	}
	
	public void remover(Categoria categoria) {
		categoria = gerenciador.merge(categoria);
		this.gerenciador.remove(categoria); //Remove a entidade
	}
	
	public Categoria buscarId(int id) {
		return gerenciador.find(Categoria.class, id); //buscar entidade do banco
	}
	
	//Para buscar todas entidades do banco
	public List<Categoria> buscarTodas() {
		String jpql = "SELECT c FROM Categoria c";
		return gerenciador.createQuery(jpql, Categoria.class).getResultList();
	}
}
