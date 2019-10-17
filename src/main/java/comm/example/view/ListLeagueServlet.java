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
		out.println("<html><title>List All Available League</title><body><table border='1'><tr><td>Season</td><td>Title</td><td>Year</td></tr>");
		for(League l: list) {
			out.println("<tr><td>"+l.getSeason()+"</td><td>"+l.getTitle()+"</td><td>"+l.getYear()+"</td></tr>");
		}
		out.println("</table><a href='index.html'>Go To Home Page</a></body></html>");
	}

}
