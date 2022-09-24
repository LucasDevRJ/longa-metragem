package com.github.lucasdevrj.longametragem.insercao;

import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.longametragem.dao.AtorDao;
import com.github.lucasdevrj.longametragem.dao.CategoriaDao;
import com.github.lucasdevrj.longametragem.dao.ElencoDao;
import com.github.lucasdevrj.longametragem.dao.FilmeDao;
import com.github.lucasdevrj.longametragem.modelo.Ator;
import com.github.lucasdevrj.longametragem.modelo.Categoria;
import com.github.lucasdevrj.longametragem.modelo.Elenco;
import com.github.lucasdevrj.longametragem.modelo.Filme;
import com.github.lucasdevrj.longametragem.util.JPAUtil;

public class CadastraFilme {

	public static void main(String[] args) {
		cadastrar();
	}

	public static void cadastrar() {
		Categoria categoria = new Categoria("Ação");
		Categoria categoria2 = new Categoria("Suspense");
		List<Categoria> categorias = new ArrayList<Categoria>();
		categorias.add(categoria);
		categorias.add(categoria2);
		
		Ator ator = new Ator("Keanu", "Reeves", "Keanu Charles Reeves é um ator canadense. Nascido em Beirute e criado em Toronto, Reeves começou a atuar em produções teatrais e em filmes de televisão antes de fazer sua estréia no cinema em Youngblood.", new Date("09/11/1964"), 1.86, "americana");
		Ator ator2 = new Ator("Ruby", "Rose", "Ruby Rose Langenheim é uma modelo, atriz e apresentadora de televisão australiana. Rose foi apresentadora na MTV Austrália, seguida por vários shows de modelagem de alto nível, incluindo Maybelline New York na Austrália.", new Date("20/03/1986"), 1.70, "australiana");
		
		List<Ator> atores = new ArrayList<Ator>();
		atores.add(ator);
		atores.add(ator2);
		
		Elenco elenco = new Elenco(atores);
		
		Filme filme = new Filme("John Wick", 16, categorias,"Forçado a honrar uma dívida da sua vida passada, John Wick assassina um alvo que não desejava matar, depois é traído pelo mandante do crime.", Year.parse("2017"), 122, elenco, "Chad Stahelski");
		Filme filme2 = new Filme("John Wick 2", 16, categorias,"Forçado a honrar uma dívida da sua vida passada, John Wick assassina um alvo que não desejava matar, depois é traído pelo mandante do crime.", Year.parse("2017"), 122, elenco, "Chad Stahelski");
		
		//System.out.println("Filme: " + ator.getElenco().getFilme());
		
		System.out.println(filme.getCategorias().get(0).getNome());
		System.out.println(filme.getCategorias().get(1).getNome());
		System.out.println(filme.getElenco().getAtores().get(0).getNome());
		
		//Gerenciador da tabela do banco
		EntityManager gerenciador = JPAUtil.getGerenciador();
		
		FilmeDao filmeDao = new FilmeDao(gerenciador);
		CategoriaDao categoriaDao = new CategoriaDao(gerenciador);
		AtorDao atorDao = new AtorDao(gerenciador);
		ElencoDao elencoDao = new ElencoDao(gerenciador);
		
		gerenciador.getTransaction().begin(); //iniciar a transação
		
		categoriaDao.cadastrar(categoria);
		categoriaDao.cadastrar(categoria2);
		filmeDao.cadastrar(filme); //chamada do método para inserir registro no banco de dados
		filmeDao.cadastrar(filme2);
		atorDao.cadastrar(ator);
		atorDao.cadastrar(ator2);
		elencoDao.cadastrar(elenco);
		
		gerenciador.getTransaction().commit(); //commitar/salvar o registro
		gerenciador.close(); //fechar o Entity Manager
	}
}
