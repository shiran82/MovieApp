package com.example.movieapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class VideoOfferResponse implements Serializable {
    @SerializedName("movie_offers")
    private List<MovieOffer> movieOffers;

    public List<MovieOffer> getMovieOffers() {
        return movieOffers;
    }

    public void setMovieOffers(List<MovieOffer> movieOffers) {
        this.movieOffers = movieOffers;
    }
}