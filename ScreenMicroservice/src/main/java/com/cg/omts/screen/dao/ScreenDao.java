package com.cg.omts.screen.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cg.omts.screen.entity.ScreenEntity;
@CrossOrigin("http://localhost:9092")
public interface ScreenDao extends JpaRepository<ScreenEntity, Integer>{
	@Query(value = "Select * from screen where theatre_id=?1", nativeQuery = true)
	List<ScreenEntity> getScreenByTheatreId(Integer TheatreId);
}
