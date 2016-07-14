package com.flp.fms.service;
import com.flp.fms.domain.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.flp.fms.domain.*;
import com.flp.fms.dao.FilmDaoImplForList;
import com.flp.fms.dao.IFilmDao;

public class FilmServiceImpl implements IFilmService {
	
	
	IFilmDao filmDao;
	
	public FilmServiceImpl() 
	{
	
		filmDao=new FilmDaoImplForList();
	}
	public void addFilm(List filmList) throws ParseException{
		Film film=new Film();
		
		film.setTitle((String) filmList.get(0));
		film.setDescription((String) filmList.get(1));
		film.setRelease_year((Date) filmList.get(2));
		film.setRental_duration((Integer) filmList.get(3));
		film.setRental_rate((Double) filmList.get(4));
		film.setLength((Integer) filmList.get(5));
		film.setReplacement_cost((Double) filmList.get(6));
		film.setRating((Double) filmList.get(7));
		film.setSpecial_features((String) filmList.get(8));
		
		Language language=new Language();
		language.setName((String) filmList.get(9));
		film.setLanguage(language);

		Category category=new Category();
		category.setName((String) filmList.get(10));
		film.setCategory(category);
		
		
	
		List actorDetails=(List) filmList.get(11);
		int j=1;
		while(j<=actorDetails.size())
		{
		int i=1;
		do{
			Actor actor=new Actor();
			actor.setFirst_name((String) actorDetails.get(0));
			i++;
			actor.setLast_name((String) actorDetails.get(1));
	film.setActors(actor);
			i++;
		}while(i<3);
		}
		
		filmDao.addFilm(film);
		
	}
	
	public void modifyFilm()
	{
		
		
	}

 
	public boolean removeFilm(int film_id){
	 return filmDao.removeFilm(film_id);
    }
	
	public Film searchFilm(int film_id){
		return filmDao.searchFilm(film_id);
	}
 
	public List<Film> getAllFilms(){
		return filmDao.getAllFilms();
		
	}
	
}
