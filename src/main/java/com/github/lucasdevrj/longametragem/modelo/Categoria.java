package com.github.lucasdevrj.longametragem.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //Indica que a classe ? uma entidade da JPA, ou seja, tem uma tabela no banco a representando
@Table(name = "categoria") //Nome da tabela do banco
public class Categoria {

	@Id //Para mostrar o atributo id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // para mostrar como o valor ? gerado
	private int id;
	private String nome;
			
	public Categoria() {
		
	}
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
}
