package com.flp.fms.service;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.flp.fms.domain.Film;
import java.util.*;

public interface IFilmService {

	abstract  void addFilm(List filmList) throws ParseException;
	abstract  void modifyFilm();
	abstract boolean removeFilm(int film_id);
	abstract  Film searchFilm(int film_id);
	abstract List<Film> getAllFilms();
}
