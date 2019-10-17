package comm.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.model.League;

/**
 * Servlet implementation class AddLeagueServlet
 */
public class AddLeagueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int year;
	private String title;
	private String season;
	private List<String> errors;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddLeagueServlet() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sYear = request.getParameter("year");
		errors = new ArrayList<String>();
		try {
			year = Integer.parseInt(sYear);
		} catch (Exception e) {
			errors.add("Year field must be numeric");
		}
		title = request.getParameter("title");
		if (title.length() <= 8) {
			errors.add("Invalid title");
		}
		season = request.getParameter("season");
		if (season.equals("Unknown")) {
			errors.add("Select a Season");
		}
		if (!errors.isEmpty()) {

			request.setAttribute("ERROR", errors);
			RequestDispatcher rd = request.getRequestDispatcher("error.view");
			rd.forward(request, response);
		} else {
			request.setAttribute("SUCCESS", new League(season, year, title));
			RequestDispatcher rd = request.getRequestDispatcher("success.view");
			rd.forward(request, response);
		}
	}

}
