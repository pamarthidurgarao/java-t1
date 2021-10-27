package com.music.book.service;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.book.document.Movie;
import com.music.book.repository.MoviesRepository;

@Service
public class MovieService {

    private static final String API_MP3 = "http://mp3teluguwap.net/mp3";

    @Autowired
    private MoviesRepository moviesRepository;

    public List<Movie> getAll() {
	return moviesRepository.findAll();
    }

    public List<Movie> search(String q) {
	return moviesRepository.findAllByName(q);
    }

    public byte[] getSong(String url) throws Exception {
	url = url.replaceAll(" ", "%20");
	HttpClient client = new DefaultHttpClient();
	HttpGet get = new HttpGet(API_MP3 + url);
	HttpResponse response = client.execute(get);
	HttpEntity entity = response.getEntity();
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	entity.writeTo(baos);
	return baos.toByteArray();
    }
}
