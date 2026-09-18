package com.dcl.servlet;

import java.io.IOException;

import com.dcl.dao.StudentDAO;
import com.dcl.dao.StudentDAOImpl;
import com.dcl.dto.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDAO sdao=new StudentDAOImpl();
		Student s=sdao.getStudentByEmail(req.getParameter("email"));
		
		if(s!=null) {
			if(s.getPassword().equals(req.getParameter("password"))) {
				resp.getWriter().println("Login succesful!, Welcome "+s.getName());
			}
			else {
				resp.getWriter().println("Invalid Password!");
			}
		}
		else {
			resp.getWriter().println("User not found!");
		}
		
		
	}
}
