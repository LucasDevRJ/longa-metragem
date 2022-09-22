package com.github.lucasdevrj.longametragem.modelo;

import java.sql.Time;
import java.time.Year;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Indica que a classe é uma entidade da JPA, ou seja, tem uma tabela no banco a representando
@Table(name = "filme") //Nome da tabela do banco
public class Filme {

	@Id //Para mostrar o atributo id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // para mostrar como o valor é gerado
	private int id;
	private String nome;
	private int faixa;
	private Categoria categoria;
	private String sinopse;
	private Year ano;
	private Time duracao;
	private String elenco;
	private String direcao;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getFaixa() {
		return faixa;
	}
	
	public void setFaixa(int faixa) {
		this.faixa = faixa;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getSinopse() {
		return sinopse;
	}
	
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	
	public Year getAno() {
		return ano;
	}
	
	public void setAno(Year ano) {
		this.ano = ano;
	}
	
	public Time getDuracao() {
		return duracao;
	}
	
	public void setDuracao(Time duracao) {
		this.duracao = duracao;
	}
	
	public String getElenco() {
		return elenco;
	}
	
	public void setElenco(String elenco) {
		this.elenco = elenco;
	}
	
	public String getDirecao() {
		return direcao;
	}
	
	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}
}
