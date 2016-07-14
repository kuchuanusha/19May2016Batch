package com.flp.fms.view;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.flp.fms.domain.*;

import com.flp.fms.service.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class UserInteraction  {


	IFilmService filmService;
	IActorService actorService;
	
	public UserInteraction()
	{
		filmService=new FilmServiceImpl();
		actorService=new ActorServiceImpl();
	}
	
	
	
	
	private static Scanner sc=new Scanner(System.in);

	public void addFilm() throws ParseException
	{
		
		List filmList=new ArrayList();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		System.out.println("Enter title");
		filmList.add(sc.next());
		
		System.out.println("Enter description");
		filmList.add(sc.next());
		
		System.out.println("Enter release date");
		
		filmList.add(dateFormat.parse(sc.next()));
		
		System.out.println("Enter rental duration");
		filmList.add(sc.nextShort());
		
		System.out.println("Enter rental rate");
		filmList.add(sc.nextInt());
		
		System.out.println("Enter length of the movie");
		filmList.add(sc.nextShort());
		
		System.out.println("Enter replacement cost");
		filmList.add(sc.nextInt());
		
		System.out.println("Enter rating");
		filmList.add(sc.next());
		
		System.out.println("Enter special features");
		filmList.add(sc.next());
		
		//Language language=new Language();
		System.out.println("Enter language name");
		filmList.add(sc.next());
		
		
		
		System.out.println("Enter category name");
		filmList.add(sc.next());
				
		Set<Actor> actor = new HashSet<Actor>();
		System.out.println("enter no of actors");
		int noofactors=sc.nextInt();
		for(int i=1;i<=noofactors;i++){
			List actorDetails=new ArrayList();
			System.out.println("Enter the actor first name");
			actorDetails.add(sc.next());
			System.out.println("Enter the actor last name");
			actorDetails.add(sc.next());
			filmList.add(actorDetails);
			
		}
		filmService.addFilm(filmList);
	}
	
	
	public void modifyFilm() throws ParseException{
		
		//Film film=userinteraction.searchFilmByName();
		
		
		
	}
	public void removeFilm(){
		System.out.println("enter id of the film to search");
		int film_id=sc.nextInt();
		if(filmService.removeFilm(film_id))
		{
			System.out.println("film Successfully removed");
		}
		else
		{
			System.out.println("film Not Found");
		}
	}
	public void searchFilm(){
		System.out.println("enter id of the film to search");
		int film_id=sc.nextInt();
		Film film=filmService.searchFilm(film_id);
		if(film!=null)
			System.out.println("film found"+film);
		else
			System.out.println("not found");
	}
	public void getAllFilms(){
		List<Film> films=filmService.getAllFilms();
		System.out.println("All films details are "+films);
		
	}
	public Actor addActor(){
	
		System.out.println("enter first name");
		String first_name=sc.next();
		
		System.out.println("enter last name");
		String last_name=sc.next();
		
		                           
		return actorService.addActor(first_name,last_name);
	}
	public void removeActor(){
		System.out.println("enter id of the actor to search");
		int actor_id=sc.nextInt();
		if(actorService.removeActor(actor_id))
		{
			System.out.println("Actor Successfully removed");
		}
		else
		{
			System.out.println("Actor Not Found");
		}
		
	}
	
	public void searchActor(){
		System.out.println("enter id of the film to search");
		int actor_id=sc.nextInt();
		Actor actor=actorService.searchActor(actor_id);
		if(actor!=null)
			System.out.println("actor found"+actor);
		else
			System.out.println("not found");
	}

	public void modifyActor(){
		//System.out.println("enter id of the film to modify");
		//Actor actor=userinteraction.searchActorByName();
	}
	public void getAllActors(){
		List<Actor> actors=actorService.getAllActors();
		System.out.println("All films details are "+actors);
		
	}
	/*public Film searchFilmByName(){
		System.out.println("enter name of the film to search");
		String name=sc.next();
		Film film=actorService.searchFilmByName();
		retun film;
	}
	
	public Film searchFilmByActor(){
		System.out.println("enter name of the Actor to search");
		String name=sc.next();
		Film film=actorService.searchFilmByActor();
		retun film;
	}
	public List<Film> searchFilmByCategory(){
		System.out.println("enter name of the Category to search");
		String category=sc.next();
		TypedQuery<Film> query = em.createQuery("Select film from Film film",Film.class);
		List<Film> filmSet=new ArrayList() ;
		for(Film film:query.getResultList())
		{
			if(film.getCategory().equals(category))
			{
				filmSet.add(film);
			}
		}
		return filmSet;
	}
	public Film[] searchFilmByLanguage(){
		System.out.println("enter name of the language to search");
		String language=sc.next();
		Film[] film=filmService.searchFilmByLanguage();
		retun film;
	}
	public List<Film> searchFilmByRating(){
		System.out.println("enter name of the Category to search");
		String rating=sc.next();
		TypedQuery<Film> query = em.createQuery("Select film from Film film where film.rating=rating",Film.class);
		List<Film> filmSet=new ArrayList() ;
		for(Film film:query.getResultList())
		{
			
				
				filmSet.add(film);
			
		}
		return filmSet;
	}
	public Language findLanguageByName(String language_name){
		TypedQuery<Language> query = em.createQuery("Select lang from Language lang",Language.class);
		
		for(Language lang:query.getResultList())
		{
			if(lang.getName().equals(language_name))
			{
				return lang;
			}
		}
		return null;
	}
	
	public Category findCategoryByName(String category_name){
		TypedQuery<Category> query = em.createQuery("Select c from Category c",Category.class);
		
		for(Category c:query.getResultList())
		{
			if(c.getName().equals(category_name))
			{
				return c;
			}
		}
		return null;
	}*/
	
}
