package com.example.movieapp.service;

import com.example.movieapp.model.VideoDataResponse;
import com.example.movieapp.model.VideoOfferResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MovieService {

    @GET("movie-offers")
    Observable<VideoOfferResponse> fetchMovieOffers();

    @GET("movie-data")
    Observable<VideoDataResponse> fetchMovieData();
}