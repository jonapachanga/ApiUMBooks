package ar.edu.um.umbooks.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/*import ar.edu.um.ingenieria.persistencia.jpa.JPAHelper;
import ar.edu.um.ingenieria.persistencia.jpa.impl.DAOImpl;
import ar.edu.um.proyecto.mvc.teams.Player;*/

public class BooksDB {
	public class PlayerDAOImpl extends DAOImpl<Player, Integer> {
		public PlayerDAOImpl() {
			super(Player.class);
		}
		
		public List<Player> filterByName(String name){
			EntityManagerFactory entityManagerFactory = JPAHelper.getJPAFactory();
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			List<Player> listPlayer = null;
			try {
				TypedQuery<Player> query = entityManager.createQuery("SELECT p FROM Player p WHERE p.nombre LIKE ?1",
						Player.class);
				query.setParameter(1, "%"+name+"%");
				listPlayer = query.getResultList();
				return listPlayer;
			} finally {
				entityManager.close();
			}
			
		}

}
