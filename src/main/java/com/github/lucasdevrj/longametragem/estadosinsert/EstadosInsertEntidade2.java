package com.github.lucasdevrj.longametragem.estadosinsert;

import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.longametragem.modelo.Ator;
import com.github.lucasdevrj.longametragem.modelo.Categoria;
import com.github.lucasdevrj.longametragem.modelo.Elenco;
import com.github.lucasdevrj.longametragem.modelo.Filme;
import com.github.lucasdevrj.longametragem.util.JPAUtil;

public class EstadosInsertEntidade2 {

	public static void main(String[] args) {
		//Instancia��o de Entidades. A JPA fica no est�gio de Transient, ou seja, est�gio de uma entidade que nunca foi persistida, logo n�o esta gravada no banco de dados, n�o tem ID e n�o esta sendo gerenciada pela JPA
		Categoria categoria = new Categoria("A��o");
		Categoria categoria2 = new Categoria("Suspense");
		List<Categoria> categorias = new ArrayList<Categoria>();
		categorias.add(categoria);
		categorias.add(categoria2);
		
		Ator ator = new Ator("Keanu", "Reeves", "Keanu Charles Reeves � um ator canadense. Nascido em Beirute e criado em Toronto, Reeves come�ou a atuar em produ��es teatrais e em filmes de televis�o antes de fazer sua estr�ia no cinema em Youngblood.", new Date("09/11/1964"), 1.86, "americana");
		
		List<Ator> atores = new ArrayList<Ator>();
		atores.add(ator);
		
		Elenco elenco = new Elenco(atores);
		
		Filme filme = new Filme("John Wick 2", 16, categorias,"For�ado a honrar uma d�vida da sua vida passada, John Wick assassina um alvo que n�o desejava matar, depois � tra�do pelo mandante do crime.", Year.parse("2017"), 122, elenco, "Chad Stahelski");
		
		EntityManager gerenciador = JPAUtil.getGerenciador();
		gerenciador.persist(filme); //Persist faz o gerenciamento pela JPA. Estado Managed.
		filme.setNome("John Wick"); //JPA ir� atualizar o valor do atributo, pois o esta gerenciando gra�as ao persist
		gerenciador.getTransaction().commit(); //commitar/salvar o registro
		gerenciador.close(); //fechar o Entity Manager
		
		filme.setNome("John Wick 3"); //n�o ir� funcionar, pois o gerenciador j� foi fechado
	}
}
