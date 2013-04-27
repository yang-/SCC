package org.scc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.scc.model.AirlineInfo;
import org.scc.util.DbUtil;

public class UserDao {
	
	private Connection connection;
	
	public UserDao() {
		connection = DbUtil.getConnection();
	}
	
	public void addUser(AirlineInfo info, String message) {		
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("insert into new_student(first_name, last_name, Email) value (?, ?, ?)");
			preparedStatement.setString(1, info.getFirstName());
			preparedStatement.setString(2, info.getLastName());
			preparedStatement.setString(3, info.getEmail());
			
			preparedStatement.executeUpdate();
			message="Done";
		} catch (SQLException e) {
			System.out.println(e);
            message="Failed";
		}
	}
	
	public void addAirline(AirlineInfo info, String message) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("insert into airline(Arrival_Date, Arrival_Time, Flight_Number, Terminal) value (?, ?, ?, ?)");
			preparedStatement.setDate(1, info.getArrivalDate());
			preparedStatement.setTime(2, info.getArrivalTime());
			preparedStatement.setString(3, info.getFlightNumber());
			preparedStatement.setInt(4, info.getTerminal());
			
			preparedStatement.executeUpdate();
			message="Done";
		} catch (SQLException e) {
            System.out.println(e);
            message="Failed";
		}
	}

	public Airline getUsersByDate (Airline airline) {
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from airline where Arrival_Date = '?'");
			preparedStatement.setDate(1, airline.getArrivalDate());
			
			ResultSet res;
			res = preparedStatement.executeQuery();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
