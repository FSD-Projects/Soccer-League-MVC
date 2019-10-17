package comm.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.model.League;

/**
 * Servlet implementation class ListLeagueServlet
 */
public class ListLeagueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<League> list = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		list = new ArrayList<League>();
		list.add(new League("Autumn", 2019, "Women's Cricket"));
		list.add(new League("Summer", 2019, "Beach Volley"));
		for(League l: list) {
			out.println(l.getSeason() + " " + l.getTitle() + " " + l.getYear() + "<br/>");
		}

	}

}
