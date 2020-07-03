package com.doaa.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId="springstudent";
		String pass="springstudent";
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver="com.mysql.jdbc.Driver";
		
		//get database connection
		try {
			
			PrintWriter out=response.getWriter();
			
			System.out.println("Connecting to database" +jdbcUrl);
			out.println("Connecting to database" +jdbcUrl);
			out.println();
			
			Class.forName(driver);
			Connection con=DriverManager.getConnection(jdbcUrl ,userId ,pass);
			
			System.out.println("Success!");
			out.println("Success!");
			
			con.close();
			
		}
		catch(Exception exc){
			exc.printStackTrace();
			throw new ServletException(exc);
			
		}
	}

}
