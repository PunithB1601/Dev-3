package com.dcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

	public static void main(String[] args) {
		//1st step of JDBC - Loading and Registering the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded");
			
		//2nd Step of JDBC - Establishing COnnection between Java and DB
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "tiger");
			System.out.println("Con Established");
			
		//3rd step of JDBC - Creating a Platform	
			Statement st=con.createStatement();
			System.out.println("Platform created");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
