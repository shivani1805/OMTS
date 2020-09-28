package com.cg.omts.screen.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.omts.screen.entity.ScreenEntity;

public interface ScreenService {
	ScreenEntity addScreen(ScreenEntity screen);

	String deleteScreen(Integer screenId);

	String editScreen(ScreenEntity screen);

	ScreenEntity getScreenById(Integer screenId);

	

	List<ScreenEntity> getAllScreens();
	List<ScreenEntity> getScreenByTheatreId(Integer theatreId);
}
