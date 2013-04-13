package org.scc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.scc.model.Airline;
import org.scc.model.User;
import org.scc.util.DbUtil;

public class UserDao {
	
	private Connection connection;
	
	public UserDao() {
		connection = DbUtil.getConnection();
	}
	
	public void addUser(User user) {		
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("insert into newstudent(firstname, lastname, DOB, email) value (?, ?, ?, ?)");
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			java.sql.Date sqlDate = new java.sql.Date(user.getDOB().getTime());
			preparedStatement.setDate(3, sqlDate);
			preparedStatement.setString(1, user.getEmail());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
            System.out.println(e);
		}
	}
	
	public void addAirline(Airline airline) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("insert into airline(arrivalDate, arrivalTime, flightNumber, terminal) value (?, ?, ?, ?)");
			java.sql.Date sqlDate = new java.sql.Date(airline.getArrivalDate().getTime());
			preparedStatement.setDate(1, sqlDate);
			preparedStatement.setString(2, airline.getArrivalTime());
			preparedStatement.setString(3, airline.getFlightNumber());
			preparedStatement.setInt(4, airline.getTerminal());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
            System.out.println(e);
		}
	}

}
