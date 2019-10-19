package comm.example.DAO;

import java.util.List;

import javax.persistence.Query;

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

	public List<League> showLeague() {
		// TODO Auto-generated method stub
		session.getTransaction().begin();
		Query query = session.createQuery("from League");
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List<League> list = query.getResultList();
		return list;
	}

	public List<League> retrieveLeague() {
		// TODO Auto-generated method stub
		session.getTransaction().begin();
		Query query = session.createQuery("from League");
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List<League> list = query.getResultList();
		return list;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		session.getTransaction();
		int recordCount = (Integer) session.createQuery("select count(*) from League").uniqueResult();
		session.getTransaction().commit();
		return recordCount;
	}

}
