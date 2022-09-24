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
		Categoria categoria = new Categoria("A��o");
		Categoria categoria2 = new Categoria("Suspense");
		List<Categoria> categorias = new ArrayList<Categoria>();
		categorias.add(categoria);
		categorias.add(categoria2);
		
		Ator ator = new Ator("Keanu", "Reeves", "Keanu Charles Reeves � um ator canadense. Nascido em Beirute e criado em Toronto, Reeves come�ou a atuar em produ��es teatrais e em filmes de televis�o antes de fazer sua estr�ia no cinema em Youngblood.", new Date("09/11/1964"), 1.86, "americana");
		Ator ator2 = new Ator("Ruby", "Rose", "Ruby Rose Langenheim � uma modelo, atriz e apresentadora de televis�o australiana. Rose foi apresentadora na MTV Austr�lia, seguida por v�rios shows de modelagem de alto n�vel, incluindo Maybelline New York na Austr�lia.", new Date("20/03/1986"), 1.70, "australiana");
		
		Ator ator3 = new Ator("Sylvester", "Stallone", "Sylvester Enzio Stallone � um ator e cineasta americano.", new Date("06/07/1946"), 1.77, "americana");
		Ator ator4 = new Ator("Yvette", "Monreal", "Yvette Monreal � uma atriz americana.", new Date("09/07/1992"), 1.65, "americana");
		
		List<Ator> atores = new ArrayList<Ator>();
		atores.add(ator);
		atores.add(ator2);
		
		List<Ator> atores2 = new ArrayList<Ator>();
		atores2.add(ator3);
		atores2.add(ator4);
		
		Elenco elenco = new Elenco(atores);
		Elenco elenco2 = new Elenco(atores2);
		
		Filme filme = new Filme("John Wick 2", 16, categorias,"For�ado a honrar uma d�vida da sua vida passada, John Wick assassina um alvo que n�o desejava matar, depois � tra�do pelo mandante do crime.", Year.parse("2017"), 122, elenco, "Chad Stahelski");
		Filme filme2 = new Filme("Rambo: At� o Fim", 18, categorias,"O veterano de guerra John Rambo est� de volta para a batalha final em busca de vingan�a contra um cartel de traficantes que est� de olho na fam�lia dele.", Year.parse("2019"), 100, elenco2, "Adrian Grunberg");
		
		//Gerenciador da tabela do banco
		EntityManager gerenciador = JPAUtil.getGerenciador();
		
		FilmeDao filmeDao = new FilmeDao(gerenciador);
		CategoriaDao categoriaDao = new CategoriaDao(gerenciador);
		AtorDao atorDao = new AtorDao(gerenciador);
		ElencoDao elencoDao = new ElencoDao(gerenciador);
		
		gerenciador.getTransaction().begin(); //iniciar a transa��o
		
		categoriaDao.cadastrar(categoria);
		categoriaDao.cadastrar(categoria2);
		filmeDao.cadastrar(filme); //chamada do m�todo para inserir registro no banco de dados
		filmeDao.cadastrar(filme2);
		atorDao.cadastrar(ator);
		atorDao.cadastrar(ator2);
		atorDao.cadastrar(ator3);
		atorDao.cadastrar(ator4);
		elencoDao.cadastrar(elenco);
		elencoDao.cadastrar(elenco2);
		
		gerenciador.getTransaction().commit(); //commitar/salvar o registro
		gerenciador.close(); //fechar o Entity Manager
	}
}
