package com.github.lucasdevrj.longametragem.insercao;

import java.util.List;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.longametragem.dao.CategoriaDao;
import com.github.lucasdevrj.longametragem.dao.FilmeDao;
import com.github.lucasdevrj.longametragem.modelo.Ator;
import com.github.lucasdevrj.longametragem.modelo.Categoria;
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
		
		List<Filme> todosFilmes = filmeDao.buscarTodas();
		todosFilmes.forEach(tf -> System.out.println(tf.toString()));
		
		List<Filme> todosFilmes2 = filmeDao.buscarNome("John Wick 2");
		todosFilmes2.forEach(tf -> System.out.println(tf.getNome()));

		List<Filme> todosFilmes3 = filmeDao.buscarPorCategoria("Ação");
		todosFilmes3.forEach(ct -> System.out.println("Categoria: " + ct.getCategorias().toString()));
		
		List<Filme> todosFilmes4 = filmeDao.buscarPorAtor("Keanu");
		todosFilmes4.forEach(ct -> System.out.println("Filme: " + ct.getNome()));
		
		Long numero = filmeDao.contar("Keanu");
		System.out.println(numero);
	}
}
