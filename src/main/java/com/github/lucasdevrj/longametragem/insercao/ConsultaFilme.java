package com.github.lucasdevrj.longametragem.insercao;

import java.util.List;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.longametragem.dao.FilmeDao;
import com.github.lucasdevrj.longametragem.modelo.Filme;
import com.github.lucasdevrj.longametragem.util.JPAUtil;

public class ConsultaFilme {

	public static void main(String[] args) {
		CadastraFilme.cadastrar();
		consultar();
	}

	private static void consultar() {
		EntityManager gerenciador = JPAUtil.getGerenciador();
		FilmeDao filmeDao = new FilmeDao(gerenciador);
		System.out.println();
		
		List<Filme> todosFilmes = filmeDao.buscarTodos();
		System.out.println("--------------------|Busca por todos os filmes|--------------------");
		todosFilmes.forEach(tf -> System.out.println(tf.toString()));
		System.out.println("-------------------------------------------------------------------");
		System.out.println();
		
		List<Filme> todosFilmes2 = filmeDao.buscarNome("John Wick 2");
		System.out.println("--------------------|Busca por nome do filme|--------------------");
		todosFilmes2.forEach(tf -> System.out.println(tf.toString()));
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
		
		List<Filme> todosFilmes3 = filmeDao.buscarPorCategoria("Ação");
		System.out.println("--------------------|Busca por nome da categoria|--------------------");
		todosFilmes3.forEach(ct -> System.out.println(ct.getCategorias().toString()));
		System.out.println("---------------------------------------------------------------------");
		System.out.println();
		
		System.out.println("--------------------|Busca por nome do ator|--------------------");
		List<Filme> todosFilmes4 = filmeDao.buscarPorAtor("Keanu");
		todosFilmes4.forEach(ct -> System.out.println(ct.getNome()));
		System.out.println("----------------------------------------------------------------");
	}
}
