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
		// Instancia��o de Entidades. A JPA fica no est�gio de Transient, ou seja,
		// est�gio de uma entidade que nunca foi persistida, logo n�o esta gravada no
		// banco de dados, n�o tem ID e n�o esta sendo gerenciada pela JPA
		Categoria categoria = new Categoria("A��o");
		Categoria categoria2 = new Categoria("Suspense");
		List<Categoria> categorias = new ArrayList<Categoria>();
		categorias.add(categoria);
		categorias.add(categoria2);

		Ator ator = new Ator("Keanu", "Reeves",
				"Keanu Charles Reeves � um ator canadense. Nascido em Beirute e criado em Toronto, Reeves come�ou a atuar em produ��es teatrais e em filmes de televis�o antes de fazer sua estr�ia no cinema em Youngblood.",
				new Date("09/11/1964"), 1.86, "americana");

		List<Ator> atores = new ArrayList<Ator>();
		atores.add(ator);

		Elenco elenco = new Elenco(atores);

		Filme filme = new Filme("John Wick 2", 16, categorias,
				"For�ado a honrar uma d�vida da sua vida passada, John Wick assassina um alvo que n�o desejava matar, depois � tra�do pelo mandante do crime.",
				Year.parse("2017"), 122, elenco, "Chad Stahelski");

		EntityManager gerenciador = JPAUtil.getGerenciador();
		gerenciador.getTransaction().begin(); // come�ar a sincroniza��o com o banco
		gerenciador.persist(filme);
		gerenciador.persist(elenco);
		gerenciador.persist(categoria);
		gerenciador.persist(categoria2);
		gerenciador.persist(ator);
		
		
		filme.setNome("John Wick"); // mudan�a no atributo

//				gerenciador.getTransaction().commit(); //salvar a mudan�a no banco
		gerenciador.flush(); // sincronizar com o banco, sem commitar mudan�as
//				gerenciador.close(); //fechar o gerenciador
		gerenciador.clear(); // remo��o de todas entidades (detached)

		// para mudar o objeto para managed
		filme = gerenciador.merge(filme); // passar do estado detached para managed, ou seja, voltar a gerenciar a JPA

		filme.setNome("John Wick 3");
		gerenciador.flush(); // sincronizar com o banco de dados
		gerenciador.remove(filme); //remover entidade
		gerenciador.flush();
	}
}
