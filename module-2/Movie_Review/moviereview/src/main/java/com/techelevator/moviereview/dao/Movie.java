package com.techelevator.moviereview.dao;

public class Movie {
    private long id;
    private String title;
    private String description;
    private int releaseYear;

    public long getId() {
        return id;
    }

    public void setId(long id) {
       this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
