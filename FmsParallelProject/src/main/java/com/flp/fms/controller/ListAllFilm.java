package com.flp.fms.controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.fms.domain.Film;
import com.flp.fms.service.FilmServiceImpl;
import com.flp.fms.service.IFilmService;
import com.google.gson.Gson;


public class ListAllFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("application/json");
		
		IFilmService filmService=new FilmServiceImpl();
		
		
		List<Film> films=filmService.getAllFilms();
		
		
		Gson gson=new Gson();
		
		String myJsonFilmObj=gson.toJson(films);
		
		
		out.println(myJsonFilmObj);
		//System.out.println(emps);
	
	}

}
