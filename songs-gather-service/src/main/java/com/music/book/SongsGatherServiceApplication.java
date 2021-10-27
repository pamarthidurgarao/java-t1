package com.music.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.music.book.repository.MoviesRepository;

@SpringBootApplication
@EnableScheduling
@EnableMongoRepositories(basePackageClasses = MoviesRepository.class)
public class SongsGatherServiceApplication {

    public static void main(String[] args) {
	SpringApplication.run(SongsGatherServiceApplication.class, args);
    }

}
