package com.flp.fms.dao;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.flp.fms.Exceptions.ParseException;
import com.flp.fms.domain.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.flp.fms.service.*;


public class FilmDaoImplForList implements IFilmDao {
	
	private EntityManager em;
	private EntityManagerFactory emf;
	
	public FilmDaoImplForList() {
		this.emf = Persistence.createEntityManagerFactory("hello");
		this.em = emf.createEntityManager();
	}
	
	
	public void addFilm(Film film){
		
		em.getTransaction().begin();
		em.persist(film);
		em.getTransaction().commit();
	}
	
	public void modifyFilm()
	{
		
		
	}

 
	public boolean removeFilm(int film_id){
		Film film=searchFilm(film_id);
		if(film!=null)
		{
			em.getTransaction().begin();
			em.remove(film);
			em.getTransaction().commit();
			return true;
		}
		else
			return false;
    }
	
	public Film searchFilm(int film_id){
		return em.find(Film.class, film_id);
		
	}
 
	public List<Film> getAllFilms(){
		
		TypedQuery<Film> query = em.createQuery("Select f from Film f",Film.class);
		return query.getResultList();
	}

}
