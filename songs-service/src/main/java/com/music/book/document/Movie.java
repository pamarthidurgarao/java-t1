package com.music.book.document;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movie {

    @Id
    private String id;
    private String name;
    private String type;
    private List<Song> songs;

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public List<Song> getSongs() {
	return songs;
    }

    public void setSongs(List<Song> songs) {
	this.songs = songs;
    }

    @Override
    public String toString() {
	return "Movie [name=" + name + ", type=" + type + ", songs=" + songs + "]";
    }

}
