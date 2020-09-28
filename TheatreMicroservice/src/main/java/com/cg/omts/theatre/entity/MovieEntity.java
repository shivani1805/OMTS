package com.cg.omts.theatre.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
@EnableAutoConfiguration
@Entity
@Table(name="movie")
public class MovieEntity {
@Column(name="movie_id")
@Id
private Integer movieId;
@Column(name="movie_name")
private String movieName;
@Column(name="movie_genre")
private String movieGenre;
public MovieEntity() {
	super();
}
public MovieEntity(Integer movieId, String movieName, String movieGenre) {
	super();
	this.movieId = movieId;
	this.movieName = movieName;
	this.movieGenre = movieGenre;
}
public Integer getMovieId() {
	return movieId;
}
public void setMovieId(Integer movieId) {
	this.movieId = movieId;
}
public String getMovieName() {
	return movieName;
}
public void setMovieName(String movieName) {
	this.movieName = movieName;
}
public String getMovieGenre() {
	return movieGenre;
}
public void setMovieGenre(String movieGenre) {
	this.movieGenre = movieGenre;
}
@Override
public String toString() {
	return "MovieEntity [movieId=" + movieId + ", movieName=" + movieName + ", movieGenre=" + movieGenre + "]";
}


}
