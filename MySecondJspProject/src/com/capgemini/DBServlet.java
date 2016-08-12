package com.capgemini;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class DBServlet
 */
@WebServlet("/DBServlet")
public class DBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		
		int empId=Integer.parseInt(request.getParameter("empId"));
		String empName=request.getParameter("empName");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try{
		
		Date date = formatter.parse(request.getParameter("jDate"));
		java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
		
		Class.forName("com.mysql.jdbc.Driver"); 
		
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anusha",
		"root","password56"); 
		
		Statement st= (Statement) con.createStatement(); 
		int i=st.executeUpdate("insert into employee values ('"+empId+"','"+empName+"','"+sqlDate+"')"); 
		if(i==1){
		response.sendRedirect("Success.jsp");
		}
		}catch(ParseException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
