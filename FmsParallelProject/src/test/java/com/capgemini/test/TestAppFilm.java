package com.capgemini.test;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import com.flp.fms.Exceptions.FieldEmptyException;

import com.flp.fms.Exceptions.NegativeFieldException;
import com.flp.fms.Exceptions.RecordNotFoundException;
import com.flp.fms.dao.IActorDao;
import com.flp.fms.dao.IFilmDao;
import com.flp.fms.domain.Actor;
import com.flp.fms.domain.Category;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;
import com.flp.fms.service.ActorServiceImpl;
import com.flp.fms.service.FilmServiceImpl;
import com.flp.fms.service.IActorService;
import com.flp.fms.service.IFilmService;

public class TestAppFilm {

	
	@Mock
	IFilmDao filmDao;
	IActorDao actorDao;
	IFilmService filmService;
	IActorService actorService;
	

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);	
		filmService=new FilmServiceImpl(filmDao);
		actorService=new ActorServiceImpl(actorDao);
	}

	
	
		//createFilm must return null when any input is null
		
		@Test(expected=com.flp.fms.Exceptions.FieldEmptyException.class)
		public void createFilmWillReturnNullWithNullInputs() throws ParseException, FieldEmptyException, NegativeFieldException{
			Map <Integer,Object> film=new HashMap<Integer,Object>();
			film.put(1, "der");
			film.put(2, "null");
			film.put(3, dateFormat.parse("20-10-1990"));
			filmService.addFilm(film);
			
			
		}
		
		
		
		
		
		//addFilm must return null when any input is invalid
		
				@Test(expected=com.flp.fms.Exceptions.NegativeFieldException.class)
				public void createFilmWillReturnNullWithInvalidInputs() throws ParseException, NegativeFieldException, FieldEmptyException{
					Map <Integer,Object> film=new HashMap<Integer,Object>();
					film.put(1, "xyz");
					film.put(2, "cyz");
					film.put(3, dateFormat.parse("20-09-1990"));
					film.put(4, -1);
					filmService.addFilm(film);	
				}
		
				
				
		//removeFilm must return valid when inputs are valid
		
		@Test
		public void removeFilmWillReturnValidWithValidInputs() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException{
			
			Mockito.when(filmDao.removeFilm(1)).thenReturn(true);
			
			assertEquals(true,filmService.removeFilm(1));
		}
		
		
		
		
		
		//removeFilm must return null with null inputs
		
		@Test(expected = com.flp.fms.Exceptions.FieldEmptyException.class)
		public void removeFilmWillReturnNullWithIdZero() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException{
			
			assertEquals(false,filmService.removeFilm(0));
		}
		
		
		
		
		
		//removeFilm must return null when record is not present
		
				@Test(expected = com.flp.fms.Exceptions.RecordNotFoundException.class)
				public void removeFilmWillReturnNullWithNoRecord() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException{
					Film film=new Film();
					Mockito.when(filmService.searchFilm(120)).thenReturn(null);
					assertEquals(false,filmService.removeFilm(120));
				}
		
				
				
				
		//removeFilm must return null if dependent method return false
		
		@Test
		public void removeFilmWillReturnNullWhenDependentMethodReturnFalse() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException{
			
			Mockito.when(filmDao.removeFilm(1)).thenReturn(false);
			
			assertEquals(false,filmService.removeFilm(1));
		}
		
		
		
		
		//removeFilm must return null with invalid inputs

		@Test(expected = com.flp.fms.Exceptions.NegativeFieldException.class)
		public void whenTheidIsZeroInRemoveFilmThrowException() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException
		{
			filmService.removeFilm(-10);
		}
		
		
		
		
		
		//Film must return valid with valid inputs
				@Test
				public void addFilmWillReturnValidWithValidInputs() throws ParseException, FieldEmptyException, NegativeFieldException {
					
					Film film=new Film();
			
					film.setTitle("xyz");
					film.setDescription("This film is an epic.");
					film.setReleaseYear(dateFormat.parse("20-03-1998"));
					film.setRentalDuration(2);
					film.setRentalRate(4.0);
					film.setLength(3);
					film.setReplacementCost(6.0);
					film.setRating(4.0);
					film.setSpecialFeatures("action");
					Category category=new Category();
					//Mockito.when(filmDao.addFilm(film)).thenReturn("added successfully");
					Language language=new Language();
					category.setName("animation");
					language.setName("english");
					film.setLanguage(language);
					film.setCategory(category);
					Actor actor=new Actor();
					actor.setFirstName("abc");
					actor.setLastName("xyz");
					film.getActors().add(actor);
				
			
					Map<Integer, Object> Film1=new HashMap<Integer, Object>();
					Film1.put(1, "xyz");
					Film1.put(2, "This film is an epic.");
					Film1.put(3,dateFormat.parse("20-03-1998"));
					Film1.put(4,2);
					Film1.put(5,4.0);
					Film1.put(6,3);
					Film1.put(7,6.0);
					Film1.put(8,4.0);
					Film1.put(9,"action");
					Film1.put(10,"animation");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
					Film1.put(11,"english");
					
				
					Map<Integer, String> actorDetails=new HashMap<Integer, String>();
					actorDetails.put(1,"abc");
					actorDetails.put(2,"xyz");
					
					Film1.put(12,actorDetails);
					//List actors1=new ArrayList();
					String res="added successfully";
				
					Mockito.when(filmDao.addFilm(film)).thenReturn(res);
					//Mockito.when(filmDao.getAllFilms()).thenReturn(Films);
					
				
				//System.out.println(actors1);
					//filmService.addFilm(Film1);
					assertEquals(res,filmDao.addFilm(film));
				}
		
		
		//modifyFilm will return valid with valid inputs
		
		@Test
		public void modifyFilmWillReturnValidWithValidInput() throws ParseException, RecordNotFoundException{
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Film film=new Film();
			
			film.setTitle("xyz");
			film.setDescription("This film is an epic.");
			film.setReleaseYear(dateFormat.parse("20-03-1998"));
			film.setRentalDuration(2);
			film.setRentalRate(4);
			film.setLength(3);
			film.setReplacementCost(6);
			film.setRating(4);
			film.setSpecialFeatures("action");
			Category category=new Category();
			Language language=new Language();
			category.setName("animation");
			language.setName("english");
			film.setLanguage(language);
			film.setCategory(category);
			Actor actor=new Actor();
			actor.setFirstName("abc");
			actor.setLastName("xyz");
			film.getActors().add(actor);
		
			List<Film> Films=new ArrayList<Film>();
			Films.add(film);
			
			
			
			//film.setTitle("abc");
		
			
			Map<Integer,Object> film1=new HashMap<Integer,Object>();
	
			film1.put(1,"xyz");
			
			film1.put(2,dateFormat.parse("20-03-1998"));
		
			film1.put(3,9.0);
			film1.put(4,"abc");
			
			
        Mockito.when(filmDao.modifyFilm(film)).thenReturn("success");
        Mockito.when(filmDao.searchFilmByDetails((String)film1.get(1), (Date)film1.get(2),(Double) film1.get(3))).thenReturn(film);
        assertEquals("success",filmService.modifyFilm(film1));
        
			}
	
		
		
		//modifyFilm will return null with null inputs
		@Test
		public void modifyFilmWillReturnNullWhenInputsAreNull() throws ParseException, RecordNotFoundException{
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Film film=new Film();
			
			film.setTitle("xyz");
			film.setDescription("This film is an epic.");
			film.setReleaseYear(dateFormat.parse("20-03-1998"));
			film.setRentalDuration(2);
			film.setRentalRate(4);
			film.setLength(3);
			film.setReplacementCost(6);
			film.setRating(4);
			film.setSpecialFeatures("action");
			Category category=new Category();
			Language language=new Language();
			category.setName("animation");
			language.setName("english");
			film.setLanguage(language);
			film.setCategory(category);
			Actor actor=new Actor();
			actor.setFirstName("abc");
			actor.setLastName("xyz");
			film.getActors().add(actor);
		
			List<Film> Films=new ArrayList<Film>();
			Films.add(film);
			
			
			
			//film.setTitle("abc");
		
			
			Map<Integer,Object> film1=new HashMap<Integer,Object>();
	
			film1.put(1,"xyz");
			
			film1.put(2,dateFormat.parse("20-03-1998"));
		
			film1.put(3,9.0);
			film1.put(4,null);
			
			
        Mockito.when(filmDao.modifyFilm(film)).thenReturn(null);
        Mockito.when(filmDao.searchFilmByDetails((String)film1.get(1), (Date)film1.get(2),(Double) film1.get(3))).thenReturn(film);
        assertEquals(null,filmService.modifyFilm(film1));
		}
		
		
		
		//modifyFilm will return null when film is not present
		@Test(expected = com.flp.fms.Exceptions.RecordNotFoundException.class)
		public void ModifyFilmIsNullWhenFilmIsNotPresent() throws ParseException, RecordNotFoundException{
		
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Map<Integer,Object> film1=new HashMap<Integer,Object>();
			
			film1.put(1,"azy");
			
			film1.put(2,dateFormat.parse("18-03-1998"));
		
			film1.put(3,9.0);
			film1.put(4,"abc");
			
	      
	        Mockito.when(filmDao.searchFilmByDetails((String)film1.get(1), (Date)film1.get(2),(Double) film1.get(3))).thenReturn(null);
	       filmService.modifyFilm(film1);
			
		}
		
		//searchFilm must return null with  null inputs
		
		@Test(expected = com.flp.fms.Exceptions.FieldEmptyException.class)
		public void whenTheidIsZeroInSearchFilmThrowException() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException
		{
			filmService.searchFilm(0);
		}
		
		
		
		
		
		
		//searchFilm must return null with  invalid inputs
				
		@Test(expected = com.flp.fms.Exceptions.NegativeFieldException.class)
				public void whenTheidIsNegativeInSearchFilmThrowException() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException
				{
					filmService.searchFilm(-1);
				}
		
		
		
		//searchFilm must return valid with  valid inputs
		
		@Test
		public void whenTheidIsValidInSearchFilmItShouldReturnValid() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException
		{
				Film film=new Film();
				Mockito.when(filmDao.searchFilm(2)).thenReturn(film);
					
				assertEquals(film,filmService.searchFilm(2));
		}
		
		
		
		//searchFilm must return null with  no record
		
		@Test(expected = com.flp.fms.Exceptions.RecordNotFoundException.class)
		public void whenTheidIsNotPresentInSearchFilmThrowException() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException
		{
			filmService.searchFilm(121);
		}
		
		
		
		

		
		
		
		}
		
		
	
