package com.cg.omts.screen.dto;

import java.math.BigInteger;
import java.util.List;

public class ScreenDto {
	private Integer screenId;
	private Integer theatreId;
	private String screenName;
	private List<String> showList;
	private String movieName;
	private Integer rows;
	private Integer columns;

	public ScreenDto(Integer screenId, Integer theatreId, String screenName, List<String> showList, String movieName,
			Integer rows, Integer columns) {
		super();
		this.screenId = screenId;
		this.theatreId = theatreId;
		this.screenName = screenName;
		this.showList = showList;
		this.movieName = movieName;
		this.rows = rows;
		this.columns = columns;
	}

	public Integer getScreenId() {
		return screenId;
	}

	public void setScreenId(Integer screenId) {
		this.screenId = screenId;
	}

	public Integer getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public List<String> getShowList() {
		return showList;
	}

	public void setShowList(List<String> showList) {
		this.showList = showList;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public void setColumns(Integer columns) {
		this.columns = columns;
	}

	@Override
	public String toString() {
		return "ScreenDto [screenId=" + screenId + ", theatreId=" + theatreId + ", screenName=" + screenName
				+ ", showList=" + showList + ", movieName=" + movieName + ", rows=" + rows + ", columns=" + columns
				+ "]";
	}

}