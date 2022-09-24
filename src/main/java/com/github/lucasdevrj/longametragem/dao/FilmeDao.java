package com.github.lucasdevrj.longametragem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.longametragem.modelo.Ator;
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
	
	public List<Filme> buscarNome(String nome) {
		String jpql = "SELECT f FROM Filme f WHERE f.nome = :nome";
		return gerenciador.createQuery(jpql, Filme.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public List<Filme> buscarPorCategoria(String nome) {
		String jpql = "SELECT f FROM Filme f "
				+ "INNER JOIN f.categorias c "
				+ "WHERE c.nome = :nome";
		return gerenciador.createQuery(jpql, Filme.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public List<Filme> buscarPorAtor(String nome) {
		String jpql = "SELECT f FROM Filme f "
				+ "INNER JOIN f.elenco e "
				+ "INNER JOIN e.atores a "
				+ "WHERE a.nome = :nome";
		return gerenciador.createQuery(jpql, Filme.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public Long contar(String nome) {
		String jpql = "SELECT COUNT(f) FROM Filme f "
				+ "INNER JOIN f.elenco e "
				+ "INNER JOIN e.atores a "
				+ "WHERE a.nome = :nome";
		return (long) gerenciador.createQuery(jpql, Long.class)
				.setParameter("nome", nome)
				.getFirstResult();
	}
}
