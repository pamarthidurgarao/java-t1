package com.music.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.book.document.Movie;
import com.music.book.repository.MoviesRepository;

@Service
public class MovieService {

    @Autowired
    private MoviesRepository moviesRepository;

    public List<Movie> getAll() {
	return moviesRepository.findAll();
    }

    public List<Movie> search(String q) {
	return moviesRepository.findAllByName(q);
    }
}
