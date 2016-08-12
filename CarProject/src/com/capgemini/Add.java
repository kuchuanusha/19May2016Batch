package com.capgemini;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	int i=0;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int carId=i++;
		System.out.println(i);
		try{
		String make=request.getParameter("make");
		String model=request.getParameter("model");
		String modelYear=request.getParameter("modelYear");
		
		Class.forName("com.mysql.jdbc.Driver"); 
		
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","password56"); 
		
		Statement st= (Statement) con.createStatement(); 
		int i=st.executeUpdate("insert into Car values ('"+carId+"','"+make+"','"+model+"','"+modelYear+"')"); 
		if(i==1){
		response.sendRedirect("SuccessAdd.jsp");
		}
		}catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
