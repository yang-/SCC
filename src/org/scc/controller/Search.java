package org.scc.controller;

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
	private static String SHOW_ALL = "/show_all.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
//        dao = new UserDao();
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
		
		UserDao dao = new UserDao();
		
		String para = request.getParameter("show");
		String forward = "";
		
		if (para == "date") {
			
			forward = SEARCH_BY_DATE;
			String q = request.getParameter("q");
			
			SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date javaDate = new Date();
			
			try {
				javaDate = dtFormat.parse(q);
			} catch (ParseException e) {
				System.out.println(e);
			}
			
			List<AirlineInfo> result = dao.getUsersByDate(new java.sql.Date(javaDate.getTime()));
			request.setAttribute("users", result);
		} else if (para == "all") {	
			
		    forward = SHOW_ALL;
		    
			List<AirlineInfo> result = dao.getAllUsers();
			request.setAttribute("users", result);
		} else {
			
			request.setAttribute("users", null);
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
