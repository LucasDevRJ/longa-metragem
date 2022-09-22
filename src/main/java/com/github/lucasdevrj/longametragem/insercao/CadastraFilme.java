package com.github.lucasdevrj.longametragem.insercao;

import java.sql.Time;
import java.time.Year;

import javax.persistence.EntityManager;
import com.github.lucasdevrj.longametragem.dao.FilmeDao;
import com.github.lucasdevrj.longametragem.modelo.Categoria;
import com.github.lucasdevrj.longametragem.modelo.Filme;
import com.github.lucasdevrj.longametragem.util.JPAUtil;

public class CadastraFilme {

	public static void main(String[] args) {
		Filme filme = new Filme("John Wick 2", 16, Categoria.ACAO, "Forçado a honrar uma dívida da sua vida passada, John Wick assassina um alvo que não desejava matar, depois é traído pelo mandante do crime.", Year.parse("2017"), Time.valueOf("02:02:00"), "Keanu Reeves, Common, Laurance Fishburne", "Chad Stahelski");
		
		//Gerenciador da tabela do banco
		EntityManager gerenciador = JPAUtil.getGerenciador();
		
		FilmeDao filmeDao = new FilmeDao(gerenciador);
		
		gerenciador.getTransaction().begin(); //iniciar a transação
		filmeDao.cadastrar(filme); //chamada do método para inserir registro no banco de dados
		gerenciador.getTransaction().commit(); //commitar/salvar o registro
		gerenciador.close(); //fechar o Entity Manager
	}
}
