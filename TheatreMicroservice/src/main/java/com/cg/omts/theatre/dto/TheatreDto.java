package com.cg.omts.theatre.dto;

import java.math.BigInteger;
import java.util.List;

public class TheatreDto {
	private Integer theatreId;
	private String theatreName;
	private String theatreCity;
	private List<String> movieList;
	private String managerName;
	private String managarContact;

	public TheatreDto(Integer theatreId, String theatreName, String theatreCity, List movieList, List screenList,
			String managerName, String managarContact) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreCity = theatreCity;
		this.movieList = movieList;
	
		this.managerName = managerName;
		this.managarContact = managarContact;
	}

	public Integer getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreCity() {
		return theatreCity;
	}

	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}

	public List getMovieList() {
		return movieList;
	}

	public void setMovieList(List movieList) {
		this.movieList = movieList;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagarContact() {
		return managarContact;
	}

	public void setManagarContact(String managarContact) {
		this.managarContact = managarContact;
	}

	@Override
	public String toString() {
		return "TheatreDto [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreCity=" + theatreCity
				+ ", movieList=" + movieList + ", managerName=" + managerName
				+ ", managarContact=" + managarContact + "]";
	}

}
