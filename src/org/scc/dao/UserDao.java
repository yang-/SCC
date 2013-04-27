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
					prepareStatement("insert into new_student(first_name, last_name, Email) value (?, ?, ?)");
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
            System.out.println(e);
		}
	}
	
	public void addAirline(Airline airline) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("insert into airline(Arrival_Date, Arrival_Time, Flight_Number, Terminal) value (?, ?, ?, ?)");
			preparedStatement.setDate(1, airline.getArrivalDate());
			preparedStatement.setTime(2, airline.getArrivalTime());
			preparedStatement.setString(3, airline.getFlightNumber());
			preparedStatement.setInt(4, airline.getTerminal());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
            System.out.println(e);
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
