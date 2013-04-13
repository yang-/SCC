package org.scc.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scc.dao.UserDao;
import org.scc.model.Airline;
import org.scc.model.User;

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
		
		Airline airline = new Airline();
		
		  String aD = request.getParameter("flightDate");
		  String aT = request.getParameter("flightArrivalTime");
		  try {
			  airline.setArrivalDate(new SimpleDateFormat("MM/dd/yyyy").parse(aD));
		  } catch (ParseException e) {
			  System.out.println(e);
		  }
		  airline.setArrivalTime(aT);
		
		  airline.setFlightNumber(request.getParameter("flightNumber"));
		  int terminal = Integer.parseInt(request.getParameter("flightArrivalTerminal"));
		  airline.setTerminal(terminal);
		  
		dao.addAirline(airline);  

		User user = new User();
		
		  user.setAirlineId(airline.getId());
		  user.setFirstName(request.getParameter("firstName"));
		  user.setLastName(request.getParameter("lastName"));
		  user.setInitDate(new Date());
		  user.setEmail(request.getParameter("email"));
		  user.setQQ(request.getParameter("qq"));
		  int sbuid = Integer.parseInt(request.getParameter("studentId"));
		  user.setSbuId(sbuid);
		  
		dao.addUser(user);
	}

}
