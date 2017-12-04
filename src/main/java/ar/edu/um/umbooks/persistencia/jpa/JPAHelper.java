package ar.edu.um.umbooks.persistencia.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JPAHelper {
	private static final Logger logger = LoggerFactory.getLogger(JPAHelper.class);
	
	private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

	private static EntityManagerFactory buildEntityManagerFactory() {
		try {
			return Persistence.createEntityManagerFactory("persistenceUM");
		} catch (Throwable ex) {
			logger.error("Error creando factory session." + ex);
			throw new RuntimeException(ex);
		}
	}

	public static EntityManagerFactory getJPAFactory() {
		return entityManagerFactory;
	}
}
