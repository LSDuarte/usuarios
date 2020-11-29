package br.com.softplan.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.softplan.modelo.Usuario;
/**
 * @author LSDuarte
 *
 * Desáfio QA Avançado | Softplan
 *
 */
public class TestaCadastraUsuario {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("usuarios");
		EntityManager em = emf.createEntityManager();

		Usuario usuario1 = new Usuario();
		usuario1.setNome("Usuario 1");
		usuario1.setEmail("usuario@gmail.com");

		em.getTransaction().begin();
		em.persist(usuario1);
		em.getTransaction().commit();
		em.close();

	}
}