package com.dcl.stream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Emp{
	Integer eid;
	String fname;
	String lname;
	String job;
	Double sal;
	Integer dno;
	String dname;
	String deptLoc;  
	String city;
	String state;
	
	public Emp() {
		
	}

	public Emp(Integer eid, String fname, String lname, String job, Double sal, Integer dno, String dname,
			String deptLoc, String city, String state) {
		super();
		this.eid = eid;
		this.fname = fname;
		this.lname = lname;
		this.job = job;
		this.sal = sal;
		this.dno = dno;
		this.dname = dname;
		this.deptLoc = deptLoc;
		this.city = city;
		this.state = state;
	}	
}

class FetchDataFromDB{
	
	
	public static List<Emp> getData(){
		Emp e=null;
		List<Emp> empList=new ArrayList<Emp>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company_1", "root", "tiger");
			
			String query=
					"SELECT *"
					+ "FROM EMP E1 JOIN DEPT D1"
					+ "ON E1.DNO=D1.DNO JOIN LOCATION L1"
					+ "ON D1.LID=L1.LID";
			
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				e=new Emp();
				e.eid=rs.getInt("eid");
				e.fname=rs.getString("fname");
				e.lname=rs.getString("lname");
				e.job=rs.getString("job");
				e.sal=rs.getDouble("sal");
				e.dno=rs.getInt("dno");
				e.dname=rs.getString("dname");
				e.deptLoc=rs.getString("location");
				e.city=rs.getString("city");
				e.state=rs.getString("state");
				empList.add(e);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empList;
	}
	
}




public class Test2 {
	
	public static void main(String[] args) {

		List<Emp> eList=FetchDataFromDB.getData();
	}
}
