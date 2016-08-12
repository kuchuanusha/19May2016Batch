package com.flp.fms.dao;


import java.util.ArrayList;
import java.util.Date;

import java.util.List;




import com.flp.fms.Exceptions.RecordNotFoundException;
import com.flp.fms.domain.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;




public class FilmDaoImplForList implements IFilmDao {
	
	private EntityManager em;
	private EntityManagerFactory emf;
	
	public FilmDaoImplForList() {
		this.emf = Persistence.createEntityManagerFactory("hello");
		this.em = emf.createEntityManager();
	}
	
	
	public String addFilm(Film film) {
		
		em.getTransaction().begin();
		em.persist(film);
		em.getTransaction().commit();
		return "added successfully";
		
	}
	
	public String modifyFilm(Film film)
	{
		
				em.getTransaction().begin();
				em.persist(film);
				em.getTransaction().commit();
				return "success";
			
		}
				
	
		


 
	public boolean removeFilm(int filmId) throws RecordNotFoundException{
		Film film=searchFilm(filmId);
		if(film!=null)
		{
			em.getTransaction().begin();
			em.remove(film);
			em.getTransaction().commit();
			return true;
		}
		else
			throw new RecordNotFoundException();
    }
	
	public Film searchFilm(int filmId){
		return em.find(Film.class, filmId);
		
	}
 
	public List<Film> getAllFilms(){
		
		TypedQuery<Film> query = em.createQuery("Select f from Film f",Film.class);
		return query.getResultList();
	}
	
	public Film searchFilmByDetails(String title,Date release_year,double rating){
		TypedQuery<Film> query = em.createQuery("Select f from Film f",Film.class);
		
		for(Film f:query.getResultList())
		{
			if(f.getTitle().equals(title) && f.getReleaseYear().equals(release_year) && f.getRating()==rating)
			{
				return f;
			}
		}
		
			return null;
	}
	
	public List<Film> searchFilmByDetails(String title){
		TypedQuery<Film> query = em.createQuery("Select f from Film f",Film.class);
		List<Film> films=new ArrayList<Film>();
		for(Film f:query.getResultList())
		{
			if(f.getTitle().equals(title) )
			{
				films.add(f);
			}
		}
		if(films!=null)
			return films;
		else
			return null;
	}
	
	public Language searchLanguageByName(String name){
		TypedQuery<Language> query = em.createQuery("Select l from Language l",Language.class);
		
		for(Language l:query.getResultList())
		{
			if(l.getName().equals(name) )
			{
				return l;
			}
		}
		
		
			return null;
	}
	

	
	public Category searchCategoryByName(String name){
		TypedQuery<Category> query = em.createQuery("Select c from Category c",Category.class);
		
		for(Category c:query.getResultList())
		{
			if(c.getName().equals(name) )
			{
				return c;
			}
		}
		
		
			return null;
	}


	
	
}
