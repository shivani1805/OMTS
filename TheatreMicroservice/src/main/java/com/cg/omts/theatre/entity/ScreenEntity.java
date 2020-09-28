package com.cg.omts.theatre.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@OneToMany
	@JoinTable(name = "show_list", joinColumns = @JoinColumn(name = "screen_id"), inverseJoinColumns = @JoinColumn(name = "show_id"))
	private List<ShowEntity> showList;
	@Column(name = "number_rows")
	private Integer rows;
	@Column(name = "number_columns")
	private Integer columns;

	public ScreenEntity() {
		super();
	}

	public ScreenEntity(Integer screenId, Integer theatreId, String screenName, List<ShowEntity> showList, Integer rows,
			Integer columns) {
		super();
		this.screenId = screenId;
		this.theatreId = theatreId;
		this.screenName = screenName;
		this.showList = showList;
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

	public List<ShowEntity> getShowList() {
		return showList;
	}

	public void setShowList(List<ShowEntity> showList) {
		this.showList = showList;
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
				+ ", showList=" + showList + ", rows=" + rows + ", columns=" + columns + "]";
	}

}
