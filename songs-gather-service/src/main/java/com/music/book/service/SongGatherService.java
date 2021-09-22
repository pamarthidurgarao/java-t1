package com.music.book.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.book.model.Movie;
import com.music.book.model.Song;

@Service
public class SongGatherService {
    private static final Logger logger = LoggerFactory.getLogger(SongGatherService.class);
    private static final String API_MP3 = "http://mp3teluguwap.net/mp3/2021/";

    private List<Movie> movies = new ArrayList<Movie>();
    private List<Movie> cacheMovies = new ArrayList<Movie>();
    private Stack<String> stack = new Stack<String>();
    private List<Song> songs = new ArrayList<Song>();

    @Autowired
    private MovieService movieService;

    public void loadMp3(int i, String url) throws Exception {
	Document doc = null;
	try {
	    doc = Jsoup.connect(url).get();
	} catch (Exception e) {
	    return;
	}

	Elements records = doc.getElementsByTag("a");
	Movie movie = null;
	for (Element record : records) {
	    if (i > 4 && type(record.attr("href")).equals("song")) {
		Song data = new Song();
		data.setId(UUID.randomUUID().toString());
		data.setLink(url.substring(url.indexOf("mp3/") + 3, url.length()) + "/" + record.attr("href"));
		data.setTitle(record.text());

		songs.add(data);
	    } else if (i > 4 && type(record.attr("href")).equals("folder")) {
		if (movie != null)
		    movies.add(movie);
		movie = new Movie();
		movie.setId(UUID.randomUUID().toString());
		movie.setName(record.text());
		songs = new ArrayList<Song>();
		movie.setSongs(songs);
		stack.push(record.attr("href"));
		url = API_MP3 + org.apache.tomcat.util.buf.StringUtils.join(stack, '/');
		loadMp3(0, url);
		stack.pop();
	    }
	    i++;
	}
    }

    public List<Movie> getMovies() throws Exception {
	return cacheMovies;
    }

    public byte[] getSong(String url) throws Exception {
	HttpClient httpClient = HttpClient.newBuilder().build();
	url = url.replaceAll(" ", "%20");
	HttpRequest request = HttpRequest.newBuilder(new URI(API_MP3 + url)).GET().build();
	HttpResponse<byte[]> response = httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());
	return response.body();
    }

    private String type(String name) {
	if (name.lastIndexOf("/") != -1) {
	    return "folder";
	}
	if (name.endsWith(".mp3")) {
	    return "song";
	}
	if (name.endsWith("zip")) {
	    return "zip";
	}
	return "";
    }

    public static void main(String[] args) throws Exception {
	SongGatherService dataService = new SongGatherService();
	dataService.cacheMovies();
    }

    public void cacheMovies() throws Exception {
	long time = System.currentTimeMillis();
	logger.info("Cache data triggered");
	loadMp3(0, API_MP3);
	cacheMovies = movies;
	for (Movie movie : movies) {
	    movieService.createAndUpdate(movie);
	}
	System.out.println(movies);
	logger.info("Cache data completed: {} ", System.currentTimeMillis() - time);
    }

}
