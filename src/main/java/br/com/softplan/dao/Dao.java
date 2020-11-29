package br.com.softplan.dao;

import javax.persistence.EntityManager;
/**
 * @author LSDuarte
 *
 * Desáfio QA Avançado | Softplan
 *
 */
public class Dao<T> {

	private final Class<T> classe;

	public Dao(Class<T> classe) {
		this.classe = classe;
	}

	EntityManager em;

	protected final EntityManager getEntityManager() {
		if (em == null || !em.isOpen()) {
			em = JPAUtil.getInstance().getEntityManager();
		}
		return em;
	}

	public void adiciona(T t) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(t);
		getEntityManager().getTransaction().commit();
		getEntityManager().close();
	}
	
}