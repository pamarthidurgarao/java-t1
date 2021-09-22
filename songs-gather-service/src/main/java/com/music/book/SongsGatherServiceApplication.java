package com.music.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.music.book.repository.MoviesRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = MoviesRepository.class)
public class SongsGatherServiceApplication {

    public static void main(String[] args) {
	SpringApplication.run(SongsGatherServiceApplication.class, args);
    }

}
