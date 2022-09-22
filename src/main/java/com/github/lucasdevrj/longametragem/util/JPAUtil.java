package com.github.lucasdevrj.longametragem.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//Classe que instancia o EntityManager
public class JPAUtil {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("longa-metragem");
	
	public static EntityManager getGerenciador() {
		return FACTORY.createEntityManager();
	}
}
