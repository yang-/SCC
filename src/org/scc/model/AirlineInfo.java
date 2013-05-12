package org.scc.model;

import java.sql.Time;
import java.util.Arrays;
import java.util.Date;

public class AirlineInfo {
	
	private java.sql.Date arrivalDate;
	private String flightNumber;
	private Time arrivalTime;
	private int terminal;

	private int userId;
	private String firstName;
	private String lastName;
	private String gender;
	private Date initDate;
	private java.sql.Date DOB;
	private String phone;
	private String QQ;
	private String QQName;
	private int majorId;
	private String email;
	private int sbuId;
	private String destination;
	private String offCampusRow;
	private String memo;
	
	private static String[] majorList = {"0","UND","AFH","ANT","AMS","ARH","ARS","BCB","BME",
		                                 "MBA","CHE","CLCS","CSE","CWL","BEE","ESE","EGL","EURO",
		                                 "GEO","GSS","SPN","HIS","ISE","JRN","LIN","MAS","ESM",
		                                 "MAT","MEC","MH","MUS","HDO","PHI","PHY","HBY","POL",
		                                 "publichealth","PUB","PSY","SOC","ARS","EST","THR","THR2",
		                                 "WST","WRT","ohter"};
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getQQName() {
		return QQName;
	}

	public void setQQName(String qQName) {
		QQName = qQName;
	}

	public int getMajorId() {
		return majorId;
	}

	public void setMajorId(String major_name) {
		this.majorId = Arrays.asList(majorList).indexOf(major_name);
	}
	
	public void setMajorId(int major_id) {
		this.majorId = major_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getInitDate() {
		return initDate;
	}

	public void setInitDate(java.util.Date now) {
		this.initDate = now;
	}

	public java.sql.Date getDOB() {
		return DOB;
	}

	public void setDOB(java.sql.Date birthDate) {
		this.DOB = birthDate;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSbuId() {
		return sbuId;
	}

	public void setSbuId(int sbuId) {
		this.sbuId = sbuId;
	}
	
	public java.sql.Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(java.sql.Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public Time getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getTerminal() {
		return terminal;
	}
	public void setTerminal(int terminal) {
		this.terminal = terminal;
	}
	
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getOffCampusRow() {
		return offCampusRow;
	}

	public void setOffCampusRow(String offCampusRow) {
		this.offCampusRow = offCampusRow;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
