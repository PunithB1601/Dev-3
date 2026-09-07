package com.dcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {

	public static void main(String[] args) {
		
		String query="SELECT * FROM STUDENT";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","tiger");
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String email=rs.getString("email");
				System.out.println(id+" "+name+" "+phone+" "+email);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
