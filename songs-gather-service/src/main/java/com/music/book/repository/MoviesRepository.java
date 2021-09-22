package com.music.book.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.music.book.model.Movie;

public interface MoviesRepository extends MongoRepository<Movie, String> {

}
