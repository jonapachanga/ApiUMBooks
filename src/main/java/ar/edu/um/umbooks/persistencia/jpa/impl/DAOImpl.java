package ar.edu.um.umbooks.persistencia.jpa.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import ar.edu.um.umbooks.persistencia.dao.CRUDInterface;
import ar.edu.um.umbooks.persistencia.jpa.JPAHelper;

public abstract class DAOImpl<T, ID extends Serializable> implements CRUDInterface<T, ID> {

	private final Class<T> persistencia;

	public DAOImpl(Class<T> classz) {
		this.persistencia = classz;
	}

	//@Override
	public void create(T entity) {
		EntityManagerFactory entityManagerFactory = JPAHelper.getJPAFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(entity);
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
			throw e;
		} finally {
			entityManager.close();
		}

	}

	//@Override
	public void remove(T entity) {
		EntityManagerFactory entityManagerFactory = JPAHelper.getJPAFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(entityManager.merge(entity));
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
			throw e;
		} finally {
			entityManager.close();
		}

	}

	//@Override
	public void update(T entity) {
		EntityManagerFactory entityManagerFactory = JPAHelper.getJPAFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = entityManager.getTransaction();
			tx.begin();
			entityManager.merge(entity);
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	//@Override
	public T findById(ID id) {
		EntityManagerFactory entityManagerFactory = JPAHelper.getJPAFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		T objeto = null;
		try {
			objeto = entityManager.find(persistencia, id);
		
			return objeto;
		} finally {
			entityManager.close();
		}
	}

	//@Override
	public List<T> findAll() {
		EntityManagerFactory entityManagerFactory = JPAHelper.getJPAFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<T> listT = null;
		try {
			TypedQuery<T> query = entityManager.createQuery("select o from " + persistencia.getSimpleName() + " o",
					persistencia);
			listT = query.getResultList();
			return listT;
		} finally {
			entityManager.close();
		}
	}

}
