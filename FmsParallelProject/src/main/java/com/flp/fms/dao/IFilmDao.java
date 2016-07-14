package com.flp.fms.dao;

import java.text.ParseException;

import java.util.List;

import com.flp.fms.domain.Film;

public interface IFilmDao {
	
	abstract  void addFilm(Film film);
	abstract  void modifyFilm();
	abstract boolean removeFilm(int film_id);
	abstract  Film searchFilm(int film_id);
	abstract List<Film> getAllFilms();

}
