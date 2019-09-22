package com.example.movieapp.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movieapp.database.MovieData;
import com.example.movieapp.database.MovieOffer;
import com.example.movieapp.repository.MovieOfferRepository;

import java.util.List;

public class MovieOfferViewModel extends AndroidViewModel {

    private MovieOfferRepository repository;

    private LiveData<List<MovieOffer>> movieOffers;

    public MovieOfferViewModel(Application application) {
        super(application);
        repository = new MovieOfferRepository(application);
        movieOffers = repository.getAllMovieOffers();
    }

    public LiveData<List<MovieOffer>> getAllMovieOffers() {
        return movieOffers;
    }

//    public void fetchAllMovieOffers() {
//        repository.fetchVideoOffers();
//    }
//
//    LiveData<List<MovieData>> getAllMovieData() {
//        return movieData;
//    }
}