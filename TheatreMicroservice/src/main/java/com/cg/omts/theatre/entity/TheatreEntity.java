package com.cg.omts.theatre.entity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.Query;


@EnableAutoConfiguration
@Entity
@Table(name = "theatre")
public class TheatreEntity {
	@Id
	@Column(name = "theatre_id")
	private Integer theatreId;
	@Column(name = "theatre_name")
	private String theatreName;
	@Column(name = "theatre_city")
	private String theatreCity;
	@ElementCollection
	private List<String> movieList=new ArrayList<>();
	@Column(name = "manager_name")
	private String managerName;
	@Column(name = "manager_contact")
	private String managerContact;

	public TheatreEntity() {
		super();
	}

	public TheatreEntity(Integer theatreId, String theatreName, String theatreCity, List<String> movieList,
			String managerName, String managerContact) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreCity = theatreCity;
		this.movieList = movieList;
		this.managerName = managerName;
		this.managerContact = managerContact;
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

	public List<String> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<String> movieList) {
		this.movieList = movieList;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerContact() {
		return managerContact;
	}

	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}

	@Override
	public String toString() {
		return "TheatreEntity [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreCity=" + theatreCity
				+ ", movieList=" + movieList + ", managerName=" + managerName + ", managerContact=" + managerContact
				+ "]";
	}

		}