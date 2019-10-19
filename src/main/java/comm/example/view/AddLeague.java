package comm.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.DAO.LeagueDAO;
import comm.example.DAO.LeagueDAOImpl;
import comm.example.model.League;

/**
 * Servlet implementation class AddLeague
 */
public class AddLeague extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> l = null;
	private String season = null;
	private String[] seasonArr;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddLeague() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		season = config.getInitParameter("season-list");
		seasonArr = season.split(",");
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

	@SuppressWarnings("unchecked")
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		l = (List<String>) request.getAttribute("ERROR");
		if (l != null) {
			out.println("Correct the following errors: <br/>");
			for (String str : l) {
				out.println("<font color='red'>" + str.toUpperCase() + "</font><br/>");
			}
		}
		out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Sign Up</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n"
				+ "\r\n" + "</head>\r\n" + "<body>\r\n" + "<!-- Default form login -->\r\n"
				+ "<form class=\"text-center border border-light p-5\" action=\"/add_league.do\">\r\n" + "\r\n"
				+ "    <p class=\"h4 mb-4\">Sign in</p>\r\n" + "\r\n" + "    <!-- Season -->\r\n"
				+ "    <input type=\"text\" id=\"defaultLoginFormEmail\" class=\"form-control mb-4\" placeholder=\"Year\"name=\"year\">\r\n"
				+ "\r\n" + "    <!-- Title -->\r\n"
				+ "    <input type=\"text\" id=\"defaultLoginFormPassword\" class=\"form-control mb-4\" placeholder=\"Title\" name=\"title\">\r\n"
				+ "\r\n" + "    <!-- Season -->\r\n");
		out.println("<select class=\"browser-default custom-select\" name=\"season\">\r\n");
		for (String str : seasonArr) {
			out.println("<option value='" + str + "'>" + str + "</option>");
		}
		out.println("</select>");
		out.println("<!-- Sign in button -->\r\n"
				+ "<button class=\"btn btn-info btn-block my-4\" type=\"submit\">Sign in</button>\r\n" + "\r\n"
				+ "</form>\r\n" + "<!-- Default form login -->\r\n" + "</body>\r\n" + "</html>");
		LeagueDAO dao = new LeagueDAOImpl();
		List<League> l = dao.retrieveLeague();
		if (!l.isEmpty()) {
			out.println("<table class=\"table\">\r\n" + "  <thead>\r\n" + "    <tr>\r\n"
					+ "      <th scope=\"col\">League ID</th>\r\n" + "      <th scope=\"col\">Season</th>\r\n"
					+ "      <th scope=\"col\">Title</th>\r\n" + "      <th scope=\"col\">Year</th>\r\n"
					+ "    </tr>\r\n" + "  </thead>\r\n" + "  <tbody>");
			for (League str : l) {
				out.println("<tr>\r\n" + "<th>\r\n" + "<td>" + str.getId() + "</td><td>" + str.getSeason() + "</td><td>"
						+ str.getTitle() + "</td><td>" + str.getYear() + "</td></tr>");
			}
		}
	}

}
