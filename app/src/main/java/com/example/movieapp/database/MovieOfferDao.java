package com.example.movieapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MovieOfferDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllMovieOffers(List<MovieOffer> movieOffers);

    @Query("SELECT * from movie_offers_table")
    LiveData<List<MovieOffer>> getAllMovieOffers();
}