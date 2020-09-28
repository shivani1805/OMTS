package com.cg.omts.theatre.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cg.omts.theatre.entity.TheatreEntity;

@CrossOrigin("http://localhost:9091")
public interface TheatreDao extends JpaRepository<TheatreEntity, Integer> {
	@Query(value = "Select * from theatre where theatre_city=?1", nativeQuery = true)
	List<TheatreEntity> getTheatreByCity(String city);
	@Query(value="Select theatre.movie_list from theatre theatre where theatre_id=?1",nativeQuery=true)
	List<String> getMovieByTheatreId(Integer theatreId);

}
