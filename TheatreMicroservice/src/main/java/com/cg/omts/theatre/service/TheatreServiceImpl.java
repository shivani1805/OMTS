package com.cg.omts.theatre.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.omts.theatre.dao.TheatreDao;
import com.cg.omts.theatre.entity.TheatreEntity;
import com.cg.omts.theatre.exception.CustomException;


@Service
public class TheatreServiceImpl implements TheatreService {
	@Autowired
	TheatreDao theatreRepository;
	final static Logger logger=LoggerFactory.getLogger(TheatreServiceImpl.class);
	
	@Override
	public TheatreEntity addTheatre(TheatreEntity theatre) {
		return theatreRepository.save(theatre);
	}

	@Override
	public String deleteTheatre(Integer theatreId) {
		Optional<TheatreEntity> theatre = theatreRepository.findById(theatreId);
		if (theatre.isPresent()) {
			theatreRepository.deleteById(theatreId);
			return "Theatre with ID: " + theatreId + " has been deleted successfully";
		} else {
			logger.error("Theatre ID '"+theatreId+"' is Invalid" );;
			return "Theatre Id is invalid";
		}
	}

	@Override
	public String editTheatre(TheatreEntity theatre) {
		Integer theatreId = theatre.getTheatreId();
		if (theatreRepository.existsById(theatreId)) {
			theatreRepository.save(theatre);
			return "Theatre with ID: '" + theatreId + "' Updated Successfully";
		} else {
			logger.error("Theatre with ID: '"+theatreId+"' is not present");
			return "Theatre with ID " + theatreId + " is not present";
		}
	}

	@Override
	public List<TheatreEntity> getTheatreByCity(String city) {

		List<TheatreEntity> allTheatres = theatreRepository.getTheatreByCity(city);

		if (allTheatres.isEmpty()) {
			logger.error("Theatre not available in city "+city);
			throw new CustomException("Sorry , could not find theatre in " + city);
		}
		else {
			return allTheatres;
		}

	}

	@Override
	public TheatreEntity getTheatreById(Integer theatreId) {
		if (theatreRepository.existsById(theatreId)) {
			Optional<TheatreEntity> theatreDetail = theatreRepository.findById(theatreId);
			TheatreEntity theatre = theatreDetail.get();
			return theatre;
		} else {
		logger.error("Theatre with ID: '"+theatreId+"' not present");
				throw new CustomException("Sorry, could not find Theatre with ID : "+theatreId);
		   }
		}

	@Override
	public List<String> getMovieByTheatreId(Integer theatreId) {
		List<String> movieList=theatreRepository.getMovieByTheatreId(theatreId);
		if(movieList.isEmpty()) {
			throw new CustomException("No movies are currently being shown in theatre with ID: "+theatreId);
		}
		else
			return movieList;
		
	}

}
