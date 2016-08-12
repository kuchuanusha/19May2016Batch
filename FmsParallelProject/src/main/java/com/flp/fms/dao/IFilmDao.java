package com.flp.fms.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.flp.fms.Exceptions.RecordNotFoundException;
import com.flp.fms.domain.Category;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;

public interface IFilmDao {
	
	  String addFilm(Film film);
	 String modifyFilm(Film film);
	 boolean removeFilm(int filmId) throws RecordNotFoundException;
	 Film searchFilm(int filmId);
	 List<Film> getAllFilms();
	

	 Language searchLanguageByName(String string);
	 Category searchCategoryByName(String string);
	 Film searchFilmByDetails(String title,Date release_year,double rating);
	

}
