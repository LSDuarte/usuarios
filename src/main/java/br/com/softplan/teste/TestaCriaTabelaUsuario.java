package br.com.softplan.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * @author LSDuarte
 *
 * Desáfio QA Avançado | Softplan
 *
 */
public class TestaCriaTabelaUsuario {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("usuarios");
		EntityManager em = emf.createEntityManager();
		em.close();
	}
}