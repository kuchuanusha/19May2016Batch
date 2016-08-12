package com.capgemini.mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String firstNumber=request.getParameter("firstNumber");
		int a=Integer.parseInt(firstNumber);
		String secondNumber=request.getParameter("secondNumber");
		int b=Integer.parseInt(secondNumber);
		String calci=request.getParameter("calci");
		if(calci.equals("add")){
			out.println("value:"+(a+b));
		}
		else if(calci.equals("sub")){
			out.println("value:"+(a-b));
		}
		else if(calci.equals("mul")){
			out.println("value:"+(a*b));
		}
		else if(calci.equals("div")){
			out.println("value:"+(a/b));
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
