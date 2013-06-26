package org.scc.controller;

import java.io.IOException;
import java.net.URLDecoder;
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

import com.google.gson.Gson;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/RegisterWS")
public class RegisterWS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterWS() {
		super();
		// dao = new UserDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("+1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDao dao = new UserDao();

		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		AirlineInfo user = new AirlineInfo();
		// 基本信息
		// lastName
		String lastName = request.getParameter("lastName");
//		lastName = new String(lastName.getBytes("ISO-8859-1"), "UTF-8");
		user.setLastName(lastName);
		// firstName
		String firstName = request.getParameter("firstName");
//		firstName = new String(firstName.getBytes("ISO-8859-1"), "UTF-8");
		user.setFirstName(firstName);
		// email
		user.setInitDate(new Date());
		user.setEmail(request.getParameter("email"));
		// emergencyContact
		String emergencyContact = request.getParameter("emergencyContact");
//		emergencyContact = new String(emergencyContact.getBytes("ISO-8859-1"), "UTF-8");
		user.setPhone(emergencyContact);
		// 航班信息
		// flightArrivalDate
		String arrivalDateStr = request.getParameter("flightArrivalDate");
		Date arrivalDate;
		try {
			arrivalDate = dateFormat.parse(arrivalDateStr);
			user.setArrivalDate(new java.sql.Date(arrivalDate.getTime()));
		} catch (ParseException e) {
			System.out.println(e);
		}
		// flightArrivalTime
		String arrivalTimeStr = request.getParameter("flightArrivalTime");
		Date arrivalTime;
		try {
			arrivalTime = timeFormat.parse(arrivalTimeStr);
			user.setArrivalTime(new java.sql.Time(arrivalTime.getTime()));
		} catch (ParseException e) {
			System.out.println(e);
		}
		// flightNumber
		user.setFlightNumber(request.getParameter("flightNumber"));
		// flightArrivalTerminal
		int terminal = Integer.parseInt(request
				.getParameter("flightArrivalTerminal"));
		user.setTerminal(terminal);
		// 石溪信息
		// destination
		String des = request.getParameter("destination");
		user.setDestination(des);
		// 校外地址
		if (des.equals("other")) {
			String offCampus = request.getParameter("offCampus-addr1") + ", "
					+ request.getParameter("offCampus-addr2") + ", "
					+ request.getParameter("offCampus-city") + ", "
					+ request.getParameter("offCampus-state") + ", "
					+ request.getParameter("offCampus-zip");
			user.setOffCampusRow(offCampus);
		} else {
			user.setOffCampusRow(null);
		}
		// qqName
		String qqName = request.getParameter("qqName");
//		qqName = new String(qqName.getBytes("ISO-8859-1"), "UTF-8");
		user.setQQName(qqName);
		// qq#
		user.setQQ(request.getParameter("qq"));
		// major
		user.setMajorId(request.getParameter("major"));
		// studentId
		int sbuid = Integer.parseInt(request.getParameter("studentId"));
		user.setSbuId(sbuid);
		// memo
		String memo = request.getParameter("memo");
//		memo = new String(memo.getBytes("ISO-8859-1"), "UTF-8");
		user.setMemo(memo);
		
		// dao
		if (dao.addUser(user)) {
			response.getWriter().write("good");
		} else {
			response.getWriter().write("bad");
		}
		dao.closeConnection();
//		System.out.println(lastName);
	}

}
