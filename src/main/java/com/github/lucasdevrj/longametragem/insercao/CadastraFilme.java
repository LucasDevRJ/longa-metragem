package com.github.lucasdevrj.longametragem.insercao;

import java.sql.Time;
import java.time.Year;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.github.lucasdevrj.longametragem.modelo.Filme;

public class CadastraFilme {

	public static void main(String[] args) {
		Filme filme = new Filme();
		filme.setNome("John Wick 2");
		filme.setFaixa(16);
		filme.setCategoria("Ação e aventura");
		filme.setSinopse("Forçado a honrar uma dívida da sua vida passada, John Wick assassina um alvo que não desejava matar, depois é traído pelo mandante do crime.");
		filme.setAno(Year.parse("2017"));
		filme.setDuracao(Time.valueOf("02:02:00"));
		filme.setElenco("Keanu Reeves, Common, Laurance Fishburne");
		filme.setDirecao("Chad Stahelski");
		
		//Classe que tem o método para construir o EntityManager
		EntityManagerFactory construtor = Persistence.createEntityManagerFactory("longa-metragem");
		
		//Interface que faz a ponte entre o banco e o Java
		EntityManager gerenciador = construtor.createEntityManager();
		gerenciador.getTransaction().begin(); //iniciar a transação
		gerenciador.persist(filme); //inserir registro no banco de dados
		gerenciador.getTransaction().commit(); //commitar/salvar o registro
		gerenciador.close(); //fechar o Entity Manager
	}
}
