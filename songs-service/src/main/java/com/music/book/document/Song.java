package com.music.book.document;

public class Song {

    private String id;
    private String title;
    private String link;

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getLink() {
	return link;
    }

    public void setLink(String link) {
	this.link = link;
    }

    @Override
    public String toString() {
	return "Song [title=" + title + ", link=" + link + "]";
    }

}
