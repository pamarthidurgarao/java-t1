package com.music.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.book.model.Movie;
import com.music.book.repository.MoviesRepository;

@Service
public class MovieService {

    @Autowired
    private MoviesRepository moviesRepository;

    public Movie createAndUpdate(Movie movie) {
	return moviesRepository.insert(movie);
    }

    public List<Movie> getAll() {
	return moviesRepository.findAll();
    }

}
