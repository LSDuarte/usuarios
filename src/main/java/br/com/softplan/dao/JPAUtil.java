package br.com.softplan.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * @author LSDuarte
 *
 * Desáfio QA Avançado | Softplan
 *
 */
public class JPAUtil {

	private static JPAUtil instance;

	private EntityManagerFactory entityManagerFactory;

	public JPAUtil() {
	}

	public static JPAUtil getInstance() {
		if (instance == null) {
			instance = new JPAUtil();
		}
		return instance;
	}

	public void createEntityManagerFactory() {
		if (entityManagerFactory == null || !entityManagerFactory.isOpen()) {
			entityManagerFactory = Persistence.createEntityManagerFactory("usuarios");
		}
	}

	public EntityManager getEntityManager() {
		try {
			createEntityManagerFactory();
			return entityManagerFactory.createEntityManager();
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao criar um EntityManager.", e);
		}
	}

	public void destroy() {
		if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
			entityManagerFactory.close();
		}
		entityManagerFactory = null;
		instance = null;
	}

	public static void main(String[] args) {
		JPAUtil.getInstance().getEntityManager();
	}
	
}