package org.scc.search;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scc.dao.UserDao;
import org.scc.model.AirlineInfo;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static String SEARCH_BY_DATE = "/search_by_date.jsp";
	
	private UserDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        dao = new UserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String para = request.getParameter("show");
		String q = request.getParameter("q");
		String forward = "";
		
		SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date javaDate = new Date();
		
		try {
			javaDate = dtFormat.parse(q);
		} catch (ParseException e) {
			System.out.println(e);
		}
		
		if (para == "date") {
			forward = SEARCH_BY_DATE;
			List<AirlineInfo> result = dao.getUsersByDate(new java.sql.Date(javaDate.getTime()));
			request.setAttribute("users", result);
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
