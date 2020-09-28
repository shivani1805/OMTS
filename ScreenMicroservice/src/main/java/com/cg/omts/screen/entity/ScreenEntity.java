package com.cg.omts.screen.entity;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
@Entity
@Table(name = "screen")
public class ScreenEntity {
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "screen_id")
	private Integer screenId;
	@Column(name = "theatre_id")
	private Integer theatreId;
	@Column(name = "screen_name")
	private String screenName;
	@Column(name = "number_rows")
	private Integer rows;
	@Column(name = "number_columns")
	private Integer columns;

	public ScreenEntity() {
		super();
	}

	public ScreenEntity(Integer screenId, Integer theatreId, String screenName, Integer rows, Integer columns) {
		super();
		this.screenId = screenId;
		this.theatreId = theatreId;
		this.screenName = screenName;

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
		return "ScreenEntity [screenId=" + screenId + ", theatreId=" + theatreId + ", screenName=" + screenName
				+ ", rows=" + rows + ", columns=" + columns + "]";
	}

}
