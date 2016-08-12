package com.flp.fms.service;
import java.text.ParseException;

import com.flp.fms.Exceptions.FieldEmptyException;

import com.flp.fms.Exceptions.NegativeFieldException;
import com.flp.fms.Exceptions.RecordNotFoundException;
import com.flp.fms.domain.Film;
import java.util.*;

public interface IFilmService {

	  String addFilm(Map filmList) throws ParseException,  FieldEmptyException, NegativeFieldException;
	   String modifyFilm(Map filmList) throws RecordNotFoundException;
	 boolean removeFilm(int filmId) throws FieldEmptyException, NegativeFieldException, RecordNotFoundException;
	  Film searchFilm(int filmId) throws FieldEmptyException, NegativeFieldException, RecordNotFoundException;
	 List<Film> getAllFilms();
}
