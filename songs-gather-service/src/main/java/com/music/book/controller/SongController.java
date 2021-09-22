package com.music.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.book.model.Movie;
import com.music.book.service.MovieService;
import com.music.book.service.SongGatherService;

@RestController
@RequestMapping("/api/v1/songs")
public class SongController {

    @Autowired
    private SongGatherService gatherService;

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAll() {
	try {
	    return new ResponseEntity<>(gatherService.getMovies(), HttpStatus.OK);
	} catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }

    @GetMapping("/db")
    public ResponseEntity<List<Movie>> getAllFromDB() {
	try {
	    return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
	} catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }

    @GetMapping("/gather")
    public ResponseEntity<Void> gather() {
	try {
	    gatherService.cacheMovies();
	    return new ResponseEntity<>(HttpStatus.OK);
	} catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }

}
