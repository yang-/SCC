package org.scc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.scc.model.AirlineInfo;
import org.scc.util.DbUtil;

public class UserDao {

	private Connection connection;

	public UserDao() {
		connection = DbUtil.getConnection();
	}

	public boolean closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}

	}

	public boolean addUser(AirlineInfo info) {
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into New_Student"
								+ "(first_name, last_name, Email, Phone, Arrival_Date,"
								+ "Arrival_Time, Flight_Number, Terminal, "
								+ "Student_Id, QQ, QQ_Name, Major_id, Campus_Address, Off_Campus_Address, Note)"
								+ "value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				preparedStatement.setString(1, info.getFirstName());
				preparedStatement.setString(2, info.getLastName());
				preparedStatement.setString(3, info.getEmail());
				preparedStatement.setString(4, info.getPhone());
				preparedStatement.setDate(5, info.getArrivalDate());
				preparedStatement.setTime(6, info.getArrivalTime());
				preparedStatement.setString(7, info.getFlightNumber());
				preparedStatement.setInt(8, info.getTerminal());
				preparedStatement.setInt(9, info.getSbuId());
				preparedStatement.setString(10, info.getQQ());
				preparedStatement.setString(11, info.getQQName());
				preparedStatement.setInt(12, info.getMajorId());
				preparedStatement.setString(13, info.getDestination());
				preparedStatement.setString(14, info.getOffCampusRow());
				preparedStatement.setString(15, info.getMemo());

				preparedStatement.executeUpdate();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}

	public List<AirlineInfo> getUsersByDate(java.sql.Date date) {

		List<AirlineInfo> users = new ArrayList<AirlineInfo>();

		try {

			// Search By Date Query Statement
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM New_Student WHERE Arrival_Date = '?'");
			preparedStatement.setDate(1, date);

			ResultSet res;
			res = preparedStatement.executeQuery();

			// retrieve results

			while (res.next()) {

				AirlineInfo user = new AirlineInfo();

				user.setUserId(res.getInt("ID"));
				user.setFirstName(res.getString("First_Name"));
				user.setLastName(res.getString("Last_Name"));
				user.setEmail(res.getString("Email"));
				user.setPhone(res.getString("Phone"));
				user.setArrivalDate(res.getDate("Arrival_Date"));
				user.setFlightNumber(res.getString("Flight_Number"));
				user.setArrivalTime(res.getTime("Arrival_Time"));
				user.setTerminal(res.getInt("Terminal"));
				user.setSbuId(res.getInt("Student_Id"));
				user.setMajorId(res.getInt("Major_id"));
				user.setQQ(res.getString("QQ"));
				user.setQQName(res.getString("QQ_Name"));
				user.setDestination(res.getString("Campus_Address"));
				user.setOffCampusRow(res.getString("Off_Campus_Address"));
				user.setMemo(res.getString("Memo"));
				users.add(user);

			}
			return users;

		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}
	
	public List<AirlineInfo> getAllUsers() {

		List<AirlineInfo> users = new ArrayList<AirlineInfo>();

		try {

			// Search By Date Query Statement
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM New_Student");

			ResultSet res;
			res = preparedStatement.executeQuery();

			// retrieve results

			while (res.next()) {

				AirlineInfo user = new AirlineInfo();

				user.setUserId(res.getInt("ID"));
				user.setFirstName(res.getString("First_Name"));
				user.setLastName(res.getString("Last_Name"));
				user.setEmail(res.getString("Email"));
				user.setPhone(res.getString("Phone"));
				user.setArrivalDate(res.getDate("Arrival_Date"));
				user.setFlightNumber(res.getString("Flight_Number"));
				user.setArrivalTime(res.getTime("Arrival_Time"));
				user.setTerminal(res.getInt("Terminal"));
				user.setSbuId(res.getInt("Student_Id"));
				user.setMajorId(res.getInt("Major_id"));
				user.setQQ(res.getString("QQ"));
				user.setQQName(res.getString("QQ_Name"));
				user.setDestination(res.getString("Campus_Address"));
				user.setOffCampusRow(res.getString("Off_Campus_Address"));
				user.setMemo(res.getString("Memo"));
				users.add(user);

			}
			return users;

		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}
}
