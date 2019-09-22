package com.example.movieapp.model;

import com.example.movieapp.model.MovieData;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class VideoDataResponse implements Serializable {
    @SerializedName("movie_data")
    private List<MovieData> movieData;

    public List<MovieData> getMovieData() {
        return movieData;
    }

    public void setMovieData(List<MovieData> movieData) {
        this.movieData = movieData;
    }
}