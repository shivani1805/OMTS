package com.cg.omts.screen.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.omts.screen.dao.ScreenDao;
import com.cg.omts.screen.entity.ScreenEntity;
import com.cg.omts.screen.exception.CustomException;

@Service
public class ScreenServiceImpl implements ScreenService {
	@Autowired
	ScreenDao screenRepository;
	final static Logger logger = LoggerFactory.getLogger(ScreenServiceImpl.class);

	@Override
	public ScreenEntity addScreen(ScreenEntity screen) {
		return screenRepository.save(screen);
	}

	@Override
	public String deleteScreen(Integer screenId) {
		Optional<ScreenEntity> screen = screenRepository.findById(screenId);
		if (screen.isPresent()) {
			screenRepository.deleteById(screenId);
			return "Screen with ID: '" + screenId + "' deleted successfully";

		} else {
		logger.error("Screen with ID: '" + screenId + "' could not be found");
			return "Oops, could not find screen with ID: '" + screenId + "'";
		}

	}

	@Override
	public String editScreen(ScreenEntity screen) {
		Integer screenId = screen.getScreenId();
		if (screenRepository.existsById(screenId)) {

			screenRepository.save(screen);
			return "Screen with ID: '" + screenId + "' Updated Successfully";
		} else {
			logger.error("Screen with ID: '" + screenId + "' could not be found");
			return "Oops, could not find screen with ID: '" + screenId + "'";
		}
	}

	@Override
	public ScreenEntity getScreenById(Integer screenId) {
		Optional<ScreenEntity> screen = screenRepository.findById(screenId);
		if (screen.isPresent()) {
			return screen.get();
		}

		else {
		logger.error("Screen with ID: '" + screenId + "' could not be found");
			throw new CustomException("Could not find screen with Id: " + screenId);
		}
	}

	@Override
	public List<ScreenEntity> getAllScreens() {
		List<ScreenEntity> screenList = screenRepository.findAll();
		if (screenList.isEmpty()) {
		logger.error("No screen could be found");
			throw new CustomException("Oops, Could not find any screen");
		} else {

			return screenList;
		}
	}

	@Override
	public List<ScreenEntity> getScreenByTheatreId(Integer theatreId) {
		List<ScreenEntity> screenList = screenRepository.getScreenByTheatreId(theatreId);

		if (screenList.isEmpty()) {
		logger.error("No screen could be found in theatre with ID: '" + theatreId + "'");
			throw new CustomException("Oops , could not find screen in theatre with ID :'" + theatreId + "'");
		} else {
			return screenList;
		}

	}

}
