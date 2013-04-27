package org.scc.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scc.dao.UserDao;
import org.scc.model.AirlineInfo;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao dao;
	
    public Controller() {
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
				
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		AirlineInfo airline = new AirlineInfo();
		
		  String aD = request.getParameter("flightDate");
		  String aT = request.getParameter("flightArrivalTime");
		  
		  Date zD;
		  try {
			  zD = dateFormat.parse(aD);
			  airline.setArrivalDate(new java.sql.Date(zD.getTime()));
		  } catch (ParseException e) {
			  System.out.println(e);
		  }
		  
		  Date zT;
		  try {			  
			  zT = timeFormat.parse(aT);
			  airline.setArrivalTime(new java.sql.Time(zT.getTime()));
		  } catch (ParseException e) {
			  System.out.println(e);
		  }
		  		
		  airline.setFlightNumber(request.getParameter("flightNumber"));
		  int terminal = Integer.parseInt(request.getParameter("flightArrivalTerminal"));
		  airline.setTerminal(terminal);
		  
		String msgAirline = new String();
		dao.addAirline(airline, msgAirline);

		AirlineInfo user = new AirlineInfo();

		  user.setFirstName(request.getParameter("firstName"));
		  user.setLastName(request.getParameter("lastName"));
		  user.setInitDate(new Date());
		  user.setEmail(request.getParameter("email"));
		  user.setQQ(request.getParameter("qq"));
		  int sbuid = Integer.parseInt(request.getParameter("studentId"));
		  user.setSbuId(sbuid);
		  
		String msgUser = new String();
		dao.addUser(user, msgUser);
		
		String nextPageOfDone = "";
		String nextPageOfFailed = "";		
		RequestDispatcher dispatcher = null;
		
		if (msgUser == "Done" && msgAirline == "Done") {
			dispatcher = getServletContext().getRequestDispatcher(nextPageOfDone);
		} else {
			dispatcher = getServletContext().getRequestDispatcher(nextPageOfFailed);
		}
		dispatcher.forward(request, response);
	}

}
