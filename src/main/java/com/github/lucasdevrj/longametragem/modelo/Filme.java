package com.github.lucasdevrj.longametragem.modelo;

import java.time.Year;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity //Indica que a classe é uma entidade da JPA, ou seja, tem uma tabela no banco a representando
@Table(name = "filme") //Nome da tabela do banco
public class Filme {

	@Id //Para mostrar o atributo id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // para mostrar como o valor é gerado
	private int id;
	private String nome;
	private int faixa;
	@ManyToMany
	private List<Categoria> categorias;
	private String sinopse;
	private Year ano;
	private int minutos;
	@OneToOne
	private Elenco elenco;
	private String direcao;
	
	public Filme(String nome, int faixa, List<Categoria> categorias, String sinopse, Year ano, int minutos,Elenco elenco, String direcao) {
		this.nome = nome;
		this.faixa = faixa;
		this.categorias = categorias;
		this.sinopse = sinopse;
		this.ano = ano;
		this.minutos = minutos;
		this.elenco = elenco;
		this.direcao = direcao;
	}

	public Filme() {
		
	}

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
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
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
	
	public int getMinutos() {
		return minutos;
	}
	
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	
	public Elenco getElenco() {
		return elenco;
	}
	
	public void setElenco(Elenco elenco) {
		this.elenco = elenco;
	}
	
	public String getDirecao() {
		return direcao;
	}
	
	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}
}
