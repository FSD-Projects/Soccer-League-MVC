package comm.example.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import comm.example.factory.HibernateUtilFactory;
import comm.example.model.League;

public class LeagueDAOImpl implements LeagueDAO {

	private Session session = null;
	private SessionFactory factory = null;

	{
		session = HibernateUtilFactory.getMySession();
	}

	public void createLeague(League league) {
		// TODO Auto-generated method stub
		try {
			session.getTransaction().begin();
			session.persist(league);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.close();
		}

	}

}
