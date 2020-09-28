package com.cg.omts.theatre.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.omts.theatre.entity.ScreenEntity;
import com.cg.omts.theatre.entity.TheatreEntity;
import com.cg.omts.theatre.service.TheatreService;


@RestController
@RequestMapping("/theatre")
@CrossOrigin("http://localhost:9091")
public class TheatreController {
	@Autowired
	TheatreService theatreService;
	@Autowired
	RestTemplate restTemplate;
	final static Logger logger=LoggerFactory.getLogger(TheatreController.class);

	@PostMapping("/add")
	public ResponseEntity<TheatreEntity> addTheatre(@RequestBody TheatreEntity theatre) {
		TheatreEntity theatreEntity = theatreService.addTheatre(theatre);
		ResponseEntity<TheatreEntity> response = new ResponseEntity<>(theatreEntity, HttpStatus.OK);
	logger.info("Theatre Added Successfully");
		return response;

	}

	@PutMapping("/update")
	public ResponseEntity<String> editTheatre(@RequestBody TheatreEntity theatre) {
		String updateResult = theatreService.editTheatre(theatre);
		ResponseEntity<String> response = new ResponseEntity<>(updateResult, HttpStatus.OK);
		logger.info("Theatre Updated Sucessfully");
		return response;
	}

	@GetMapping("/viewTheatreById/id={theatreId}")
	public ResponseEntity<TheatreEntity> getTheatreById(@PathVariable Integer theatreId) {
		TheatreEntity theatre = theatreService.getTheatreById(theatreId);
		ResponseEntity<TheatreEntity> response = new ResponseEntity<>(theatre, HttpStatus.OK);
	logger.info("Theatre Details returned successfully");
		return response;
	}

	@DeleteMapping("/deleteTheatre/id={theatreId}")
	public ResponseEntity<String> deleteTheatre(@PathVariable Integer theatreId) {
		String deleteResult = theatreService.deleteTheatre(theatreId);
		ResponseEntity<String> response = new ResponseEntity<>(deleteResult, HttpStatus.OK);
	logger.info("Theatre with ID: "+theatreId+" deleted successfully");
		return response;

	}

	@GetMapping("/viewTheatreByCity/city={city}")
	public ResponseEntity<List<TheatreEntity>> getTheatreByCity(@PathVariable String city) {
		List<TheatreEntity> theatreList = theatreService.getTheatreByCity(city);
		ResponseEntity<List<TheatreEntity>> response = new ResponseEntity<>(theatreList, HttpStatus.OK);
		logger.info("Theatre List returned successfully");
		return response;

	}
	
	@GetMapping("/screenByTheatreId/id={theatreId}")
	public ResponseEntity<List<ScreenEntity>> getScreenByTheatreId(@PathVariable Integer theatreId){
		String url="http://localhost:9092/screen/getScreenByTheatre/id="+theatreId;
		List<ScreenEntity> screen=restTemplate.getForObject(url, List.class);
		ResponseEntity<List<ScreenEntity>> response=new ResponseEntity(screen,HttpStatus.OK);
		logger.info("Screens in Theatre with ID: "+theatreId+" returned successfully");
		return response;
	}
	@GetMapping("/movieByTheatreId/id={theatreId}")
	public ResponseEntity<List<String>> getMovieByTheatreId(@PathVariable Integer theatreId){
		List<String> movieList=theatreService.getMovieByTheatreId(theatreId);
		ResponseEntity<List<String>> response=new ResponseEntity<>(movieList,HttpStatus.OK);
		return response;
	}
//	@GetMapping("/searchMovie/name={movieName}")
//	public ResponseEntity<MovieEntity> searchMovie(@PathVariable String movieName){
//		String url=
//	}
//viewShowByTheatreId;
	
}
	
   

