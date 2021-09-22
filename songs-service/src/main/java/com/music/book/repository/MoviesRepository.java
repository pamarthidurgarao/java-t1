package com.music.book.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.music.book.document.Movie;

public interface MoviesRepository extends MongoRepository<Movie, String> {

    @Query("{ 'name' : { '$regex' : ?0 , $options: 'i'}}")
    List<Movie> findAllByName(String q);
}
