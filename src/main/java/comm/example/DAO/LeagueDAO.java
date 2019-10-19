package comm.example.DAO;

import java.util.List;

import comm.example.model.League;

public interface LeagueDAO {
	public void createLeague(League league);
	public List<League> showLeague();
	//public void deleteLeague(League league);
	public List<League> retrieveLeague();
	public int getCount();
}
