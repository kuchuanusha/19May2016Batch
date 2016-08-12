package com.capgemini;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class View
 */
//@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			PrintWriter out=response.getWriter();
					
		Class.forName("com.mysql.jdbc.Driver"); 
		
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","password56"); 
		
		Statement st= (Statement) con.createStatement();
		
		 String sql = "SELECT id, first, last, age FROM Registration";
	      ResultSet rs = (ResultSet) st.executeQuery(sql);
	     
	      while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("carid");
	         String make  = rs.getString("make");
	         String model  = rs.getString("model");
	         String modelYear = rs.getString("modelYear");
	         
	         
	         
	         System.out.print("ID: " + id);
	         System.out.print(", Make: " + make);
	         System.out.print(", Model: " + model);
	         System.out.println(", ModelYear: " + modelYear);
	      
	      } 
	      out.println("<html>");
			out.println("<body>");
			out.println("Do u wish to continue");
			out.println("<a href= Home.html >");
			out.println("Yes");
			out.println("</a>");
			out.println("<a href= final.html >");
			out.println("No");
			out.println("</a>");
			
			out.println("<input type=submit />");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
	      
	    
		}catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
