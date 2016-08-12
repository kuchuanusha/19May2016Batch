package com.capgemini;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
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
	 * @param ps 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, PreparedStatement ps) throws ServletException, IOException {
		try{
			int carId=Integer.parseInt(request.getParameter("carid"));
			
Class.forName("com.mysql.jdbc.Driver"); 
			
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","password56"); 
			
			Statement st= (Statement) con.createStatement(); 
			
			
			String sql = "SELECT carId, make, model, modelYear FROM Car";
		      ResultSet rs = (ResultSet) st.executeQuery(sql);
		     
		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("carId");
		         String make  = rs.getString("make");
		         String model  = rs.getString("model");
		         String modelYear = rs.getString("modelYear");
		         if(id==carId){
		        	 String make1=request.getParameter("make");
		 			String model1=request.getParameter("model");
		 			String modelYear1=request.getParameter("modelYear"); 
		 			/*String sql1 = "UPDATE Car " +"SET make = ?,model=?,modelYear=? WHERE id=?";*/
		 			ps = con.prepareStatement("update Car set make=?, model=?, modelYear=? where carId=?"); 
	                ps.setString(1,make1); 
	                ps.setString(2,model1); 
	                ps.setString(3,modelYear1); 
	                ps.setInt(4,id); 

	                
	                int i = ps.executeUpdate(); 
	                


	                if(i!=0)    {
	                	response.sendRedirect("SuccessAdd.jsp");
	                } 
	               
		         }
		         
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
