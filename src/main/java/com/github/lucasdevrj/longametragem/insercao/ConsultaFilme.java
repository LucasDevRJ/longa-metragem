package com.github.lucasdevrj.longametragem.insercao;

import java.util.List;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.longametragem.dao.FilmeDao;
import com.github.lucasdevrj.longametragem.modelo.Filme;
import com.github.lucasdevrj.longametragem.util.JPAUtil;

public class ConsultaFilme {

	public static void main(String[] args) {
		CadastraFilme.cadastrar();
		
		EntityManager gerenciador = JPAUtil.getGerenciador();
		FilmeDao filmeDao = new FilmeDao(gerenciador);
		
		List<Filme> todosFilmes = filmeDao.buscarTodas();
		todosFilmes.forEach(tf -> System.out.println(tf.toString()));
	}
}
