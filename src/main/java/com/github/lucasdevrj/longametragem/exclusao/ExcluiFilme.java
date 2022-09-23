package com.github.lucasdevrj.longametragem.exclusao;

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

public class ExcluiFilme {

	public static void main(String[] args) {
		// Instanciação de Entidades. A JPA fica no estágio de Transient, ou seja,
		// estágio de uma entidade que nunca foi persistida, logo não esta gravada no
		// banco de dados, não tem ID e não esta sendo gerenciada pela JPA
		Categoria categoria = new Categoria("Ação");
		Categoria categoria2 = new Categoria("Suspense");
		List<Categoria> categorias = new ArrayList<Categoria>();
		categorias.add(categoria);
		categorias.add(categoria2);

		Ator ator = new Ator("Keanu", "Reeves",
				"Keanu Charles Reeves é um ator canadense. Nascido em Beirute e criado em Toronto, Reeves começou a atuar em produções teatrais e em filmes de televisão antes de fazer sua estréia no cinema em Youngblood.",
				new Date("09/11/1964"), 1.86, "americana");

		List<Ator> atores = new ArrayList<Ator>();
		atores.add(ator);

		Elenco elenco = new Elenco(atores);

		Filme filme = new Filme("John Wick 2", 16, categorias,
				"Forçado a honrar uma dívida da sua vida passada, John Wick assassina um alvo que não desejava matar, depois é traído pelo mandante do crime.",
				Year.parse("2017"), 122, elenco, "Chad Stahelski");

		EntityManager gerenciador = JPAUtil.getGerenciador();
		gerenciador.getTransaction().begin(); // começar a sincronização com o banco
		gerenciador.persist(filme);
		gerenciador.persist(elenco);
		gerenciador.persist(categoria);
		gerenciador.persist(categoria2);
		gerenciador.persist(ator);
		
		
		filme.setNome("John Wick"); // mudança no atributo

//				gerenciador.getTransaction().commit(); //salvar a mudança no banco
		gerenciador.flush(); // sincronizar com o banco, sem commitar mudanças
//				gerenciador.close(); //fechar o gerenciador
		gerenciador.clear(); // remoção de todas entidades (detached)

		// para mudar o objeto para managed
		filme = gerenciador.merge(filme); // passar do estado detached para managed, ou seja, voltar a gerenciar a JPA

		filme.setNome("John Wick 3");
		gerenciador.flush(); // sincronizar com o banco de dados
		gerenciador.remove(filme); //remover entidade
		gerenciador.flush();
	}
}
