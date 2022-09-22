package com.github.lucasdevrj.longametragem;

import java.sql.Time;
import java.time.Year;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity //Indica que a classe é uma entidade da JPA, ou seja, tem uma tabela no banco a representando
@Table(name = "filme") //Nome da tabela do banco
public class Filme {

	private int id;
	private String nome;
	private int faixa;
	private Categoria categoria;
	private String sinopse;
	private Year ano;
	private Time duracao;
	
}
