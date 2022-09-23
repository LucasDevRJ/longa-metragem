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
		//Instanciação de Entidades. A JPA fica no estágio de Transient, ou seja, estágio de uma entidade que nunca foi persistida, logo não esta gravada no banco de dados, não tem ID e não esta sendo gerenciada pela JPA
		Categoria categoria = new Categoria("Ação");
		Categoria categoria2 = new Categoria("Suspense");
		List<Categoria> categorias = new ArrayList<Categoria>();
		categorias.add(categoria);
		categorias.add(categoria2);
		
		Ator ator = new Ator("Keanu", "Reeves", "Keanu Charles Reeves é um ator canadense. Nascido em Beirute e criado em Toronto, Reeves começou a atuar em produções teatrais e em filmes de televisão antes de fazer sua estréia no cinema em Youngblood.", new Date("09/11/1964"), 1.86, "americana");
		
		List<Ator> atores = new ArrayList<Ator>();
		atores.add(ator);
		
		Elenco elenco = new Elenco(atores);
		
		Filme filme = new Filme("John Wick 2", 16, categorias,"Forçado a honrar uma dívida da sua vida passada, John Wick assassina um alvo que não desejava matar, depois é traído pelo mandante do crime.", Year.parse("2017"), 122, elenco, "Chad Stahelski");
		
		EntityManager gerenciador = JPAUtil.getGerenciador();
		gerenciador.persist(filme); //Persist faz o gerenciamento pela JPA. Estado Managed.
		filme.setNome("John Wick"); //JPA irá atualizar o valor do atributo, pois o esta gerenciando graças ao persist
		gerenciador.getTransaction().commit(); //commitar/salvar o registro
		gerenciador.close(); //fechar o Entity Manager
		
		filme.setNome("John Wick 3"); //não irá funcionar, pois o gerenciador já foi fechado
	}
}
