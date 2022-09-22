package com.github.lucasdevrj.longametragem.insercao;

import java.sql.Time;
import java.time.Year;

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
		
		System.out.println(filme.getDuracao());
	}
}
