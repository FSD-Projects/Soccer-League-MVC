package comm.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.DAO.LeagueDAO;
import comm.example.DAO.LeagueDAOImpl;
import comm.example.model.League;

/**
 * Servlet implementation class ShowLeagueServlet
 */
public class ShowLeagueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowLeagueServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		LeagueDAO dao = new LeagueDAOImpl();
		List<League> list = dao.showLeague();
		out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Show all leagues</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n"
				+ "\r\n" + "</head>\r\n" + "<body><table class=\"table\">\r\n" + 
						"  <thead class=\"black white-text\">\r\n" + 
						"    <tr>\r\n" + 
						"      <th scope=\"col\">League ID</th>\r\n" + 
						"      <th scope=\"col\">Title</th>\r\n" + 
						"      <th scope=\"col\">Season</th>\r\n" + 
						"      <th scope=\"col\">Year</th>\r\n" + 
						"    </tr>\r\n" + 
						"  </thead>\r\n" + 
						"  <tbody>");
		for(League str: list) {
			out.println("<tr><td>" + str.getId() + "</td> "+ "<td>" + str.getTitle() + "</td>" + "<td>" + str.getSeason() + "</td>" + "<td>" + str.getYear() + "</td></tr>");
		}
		out.println("</tbody></body></html>");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
