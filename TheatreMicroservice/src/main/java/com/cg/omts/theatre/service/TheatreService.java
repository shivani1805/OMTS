package com.cg.omts.theatre.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.omts.theatre.entity.TheatreEntity;

public interface TheatreService {

	TheatreEntity addTheatre(TheatreEntity theatre);

	String deleteTheatre(Integer theatreId);

	String editTheatre(TheatreEntity theatre);

	List<TheatreEntity> getTheatreByCity(String city);

	TheatreEntity getTheatreById(Integer theatreId);
	 
	List<String> getMovieByTheatreId(Integer theatreId);

}
