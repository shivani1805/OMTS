package com.cg.omts.theatre.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
@Entity
@Table(name = "show_list")
public class ShowEntity {
	@Id
	@Column(name = "show_id")
	private Integer showId;
	@Column(name = "show_time")
	private LocalDateTime showTime;
	@Column(name = "movie_name")
	private String movieName;

	public ShowEntity() {
		super();
	}

	public ShowEntity(Integer showId, LocalDateTime showTime, String movieName) {
		super();
		this.showId = showId;
		this.showTime = showTime;
		this.movieName = movieName;
	}

	public Integer getShowId() {
		return showId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	public LocalDateTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	@Override
	public String toString() {
		return "ShowEntity [showId=" + showId + ", showTime=" + showTime + ", movieName=" + movieName + "]";
	}

}
