package com.example.movieapp.model;

import com.google.gson.annotations.SerializedName;

public class MovieOffer {
    @SerializedName("movie_id")
    private String movieId;
    private String price;
    private boolean available;

    public String getMovieId() {
        return movieId;
    }

    public String getPrice() {
        return price;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
