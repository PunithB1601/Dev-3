package com.dcl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.dcl.dto.User;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class DemoServlet extends HttpServlet{

	Map<Integer, Object> userData=new HashMap();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		int userId=Integer.parseInt(id);
		String userName=req.getParameter("username");
		String place=req.getParameter("place");
		String phone=req.getParameter("phone");
		
		User u=new User(userId,userName,place,phone); 
		userData.put(userId, u);
		
		resp.getWriter().println("<h1>Data added successfully!, Welcome "+userName);
		System.out.println(userData.get(userId));
	}
	

	
}
