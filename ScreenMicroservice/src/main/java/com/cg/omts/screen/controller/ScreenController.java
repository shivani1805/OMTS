package com.cg.omts.screen.controller;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

import com.cg.omts.screen.entity.ScreenEntity;
import com.cg.omts.screen.service.ScreenService;
@Validated
@RestController
@RequestMapping("/screen")
@CrossOrigin("http://localhost:9092")
public class ScreenController {
	@Autowired
	private ScreenService screenService;
	@Autowired
	RestTemplate restTemplate;
	final static Logger logger=LoggerFactory.getLogger(ScreenController.class);

	@PostMapping("/new")
	public ResponseEntity<ScreenEntity> addNewScreen(@RequestBody ScreenEntity screen) {
		ScreenEntity screenEntity = screenService.addScreen(screen);
		ResponseEntity<ScreenEntity> response = new ResponseEntity<>(screenEntity, HttpStatus.OK);
		logger.info("New Screen Added Successfully");
		return response;

	}

	@GetMapping("/getScreenById/id={screenId}")
	public ResponseEntity<ScreenEntity> getScreenById(@PathVariable Integer screenId) {
		ScreenEntity screen = screenService.getScreenById(screenId);
		ResponseEntity<ScreenEntity> response = new ResponseEntity<>(screen, HttpStatus.OK);
		logger.info("Screen Details with Screen ID: '"+screenId+"' returned successully");
		return response;
	}

	@DeleteMapping("/delete/id={screenId}")
	public ResponseEntity<String> deleteScreen(@PathVariable Integer screenId) {
		String deleteResult = screenService.deleteScreen(screenId);
		ResponseEntity<String> response = new ResponseEntity<>(deleteResult, HttpStatus.OK);
	logger.info("Screen with ID: '"+screenId+"' deleted successfully");
		return response;

	}

	@PutMapping("/update")
	public ResponseEntity<String> editScreen(@RequestBody ScreenEntity screen) {
		String updateResult = screenService.editScreen(screen);
		ResponseEntity<String> response = new ResponseEntity<>(updateResult, HttpStatus.OK);
		logger.info("Screen Updated Successfully");
		return response;

	}

	@GetMapping("/getAllScreens")
	public ResponseEntity<List<ScreenEntity>> getAllScreens() {
		List<ScreenEntity> screenList = screenService.getAllScreens();
		ResponseEntity<List<ScreenEntity>> response = new ResponseEntity<>(screenList, HttpStatus.OK);
		logger.info("Screen Details returned sucessfully");
		return response;

	}

	@GetMapping("/getScreenByTheatre/id={theatreId}")
	public ResponseEntity<List<ScreenEntity>> getScreenByTheatreId(@PathVariable Integer theatreId) {
		List<ScreenEntity> screenList = screenService.getScreenByTheatreId(theatreId);
		ResponseEntity<List<ScreenEntity>> response = new ResponseEntity<>(screenList, HttpStatus.OK);
		logger.info("Details of Screen in theatre with ID: '"+theatreId+"' returned successfully" );
		return response;
	}
	//viewShowByScreenId
	
}
