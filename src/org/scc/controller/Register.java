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
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String SUCCESS = "/done.html";
    private static String FAIL = "/error.html";

	public Register() {
		super();
//		dao = new UserDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		UserDao dao = new UserDao();
		String forward="";
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		AirlineInfo user = new AirlineInfo();

		String aD = request.getParameter("flightDate");
		String aT = request.getParameter("flightArrivalTime");

		Date zD;
		try {
			zD = dateFormat.parse(aD);
			user.setArrivalDate(new java.sql.Date(zD.getTime()));
		} catch (ParseException e) {
			System.out.println(e);
		}

		Date zT;
		try {
			zT = timeFormat.parse(aT);
			user.setArrivalTime(new java.sql.Time(zT.getTime()));
		} catch (ParseException e) {
			System.out.println(e);
		}

		user.setFlightNumber(request.getParameter("flightNumber"));
		int terminal = Integer.parseInt(request
				.getParameter("flightArrivalTerminal"));
		user.setTerminal(terminal);

//		user.setFirstName(request.getParameter("firstName"));
//		user.setLastName(request.getParameter("lastName"));
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		firstName = new String(firstName.getBytes("ISO-8859-1"),"UTF-8");
		lastName = new String(lastName.getBytes("ISO-8859-1"),"UTF-8");
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
		user.setInitDate(new Date());
		user.setEmail(request.getParameter("email"));
		user.setPhone(request.getParameter("emergencyContact"));
		user.setQQ(request.getParameter("qq"));
		String qqName = request.getParameter("qqName");
		qqName = new String(qqName.getBytes("ISO-8859-1"),"UTF-8");
		user.setQQName(qqName);
		int sbuid = Integer.parseInt(request.getParameter("studentId"));
		user.setSbuId(sbuid);
		user.setMajorId(request.getParameter("major"));

		String des = request.getParameter("destination");
		user.setDestination(des);
		if (des.equals("other"))
			user.setOffCampusRow(request.getParameter("offCampus"));
		else
			user.setOffCampusRow(null);

		String memo = request.getParameter("memo");
		if(memo != null){
			memo = new String(memo.getBytes("ISO-8859-1"),"UTF-8");
			user.setMemo(memo);
		} else {
			user.setMemo(null);
		}

		if (dao.addUser(user)) {
			forward = SUCCESS;
		} else {
			forward = FAIL;
		}
		dao.closeConnection();
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
//		response.sendRedirect(forward);
//        System.out.println(lastName+firstName);
	}

}
