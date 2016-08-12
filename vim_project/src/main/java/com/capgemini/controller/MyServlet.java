package com.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.service.ICarService;
import com.capgemini.service.carServiceImpl;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICarService carService=new carServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		switch(request.getParameter("Car"))
		{
			case "addcar":addCar(request, response);
							break;
			case "editcar":editCar(request,response);
							break;
			case "deletecar":deleteCar(request, response);
							break;
			case "viewcar":viewCar(request, response);
			                 break;				
		}
	}
	
	private void viewCar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		PrintWriter out=response.getWriter();
		
		request.setAttribute("msg", "All cars Details are");
		request.setAttribute("allCars",carService.viewCar());
		request.getRequestDispatcher("statusMsg.jsp").forward(request, response);
	}

	private void deleteCar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		
		if(carService.deleteCar(id))
		{
			request.setAttribute("msg", "car deleted sucessfully");
		}
		else
		{
			request.setAttribute("msg", "error");
		}	
		request.getRequestDispatcher("statusMsg.jsp").forward(request, response);
		
	}

	private void editCar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out=response.getWriter();
		Map<String, Object> carDetails=new HashMap<String, Object>();
		
		carDetails.put("id" ,Integer.parseInt(request.getParameter("id")));
		carDetails.put("make", request.getParameter("make"));
		carDetails.put("model", request.getParameter("model"));
		carDetails.put("modelYear", request.getParameter("modelYear"));
		
		if(carService.editCar(carDetails))
		{
			request.setAttribute("msg", "car edited sucessfully");
		}
		else
		{
			request.setAttribute("msg", "error");
		}		
		request.getRequestDispatcher("statusMsg.jsp").forward(request, response);
	}

	private void addCar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		PrintWriter out=response.getWriter();
		Map<String, String> carDetails=new HashMap<String, String>();
		
		carDetails.put("make", request.getParameter("make"));
		carDetails.put("model", request.getParameter("model"));
		carDetails.put("modelYear", request.getParameter("modelYear"));
		
		if(carService.addCar(carDetails))
		{
			request.setAttribute("msg", "car added sucessfully");
			
		}
		else
		{
			request.setAttribute("msg", "error");
		}	
		request.getRequestDispatcher("statusMsg.jsp").forward(request, response);
	}

}
