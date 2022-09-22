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
		filme.setCategoria("A��o e aventura");
		filme.setSinopse("For�ado a honrar uma d�vida da sua vida passada, John Wick assassina um alvo que n�o desejava matar, depois � tra�do pelo mandante do crime.");
		filme.setAno(Year.parse("2017"));
		filme.setDuracao(Time.valueOf("02:02:00"));
		filme.setElenco("Keanu Reeves, Common, Laurance Fishburne");
		filme.setDirecao("Chad Stahelski");
		
		//Classe que tem o m�todo para construir o EntityManager
		EntityManagerFactory construtor = Persistence.createEntityManagerFactory("longa-metragem");
		
		//Interface que faz a ponte entre o banco e o Java
		EntityManager gerenciador = construtor.createEntityManager();
		gerenciador.getTransaction().begin(); //iniciar a transa��o
		gerenciador.persist(filme); //inserir registro no banco de dados
		gerenciador.getTransaction().commit(); //commitar/salvar o registro
		gerenciador.close(); //fechar o Entity Manager
	}
}
