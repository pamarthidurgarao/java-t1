package com.music.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.music.book.document.Movie;
import com.music.book.service.MovieService;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAll() {
	return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> search(@RequestParam String q) {
	return new ResponseEntity<>(movieService.search(q), HttpStatus.OK);
    }

    @GetMapping("/song")
    public ResponseEntity<byte[]> song(@RequestParam String url) {
	try {
	    return new ResponseEntity<>(movieService.getSong(url), HttpStatus.OK);
	} catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
    }
}
