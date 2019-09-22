package com.example.movieapp.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.movieapp.database.MovieOffer;
import com.example.movieapp.database.MovieOfferDao;
import com.example.movieapp.database.MovieOfferRoomDatabase;
import com.example.movieapp.model.VideoDataResponse;
import com.example.movieapp.model.VideoOfferResponse;
import com.example.movieapp.service.APIClient;
import com.example.movieapp.service.MovieService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MovieOfferRepository {

    private MovieOfferDao movieOfferDao;
    private LiveData<List<MovieOffer>> movieOffersLiveData;
    private CompositeDisposable disposable;

    public MovieOfferRepository(Application application) {
        MovieOfferRoomDatabase db = MovieOfferRoomDatabase.getDatabase(application);
        movieOfferDao = db.wordDao();
        movieOffersLiveData = movieOfferDao.getAllMovieOffers();

        fetchVideoOffers();
    }

    public LiveData<List<MovieOffer>> getAllMovieOffers() {
        return movieOffersLiveData;
    }

    public void fetchVideoOffers() {
        MovieService movieService = APIClient.getClient().create(MovieService.class);


        Observable<VideoOfferResponse> videoOfferResponseObservable = movieService.fetchMovieOffers();
        Observable<VideoDataResponse> videoDataResponseObservable = movieService.fetchMovieData();

        Disposable subscribe = Observable.zip(videoOfferResponseObservable, videoDataResponseObservable,
                (videoOfferResponse, videoDataResponse) -> {

            Map<String, MovieOffer> movieOfferMap = new HashMap<>();
            List<MovieOffer> movieOffers = new ArrayList<>();

            List<com.example.movieapp.model.MovieOffer> movieOffersResponse = videoOfferResponse.getMovieOffers();
            for (int i = 0; i < movieOffersResponse.size(); i++) {
                com.example.movieapp.model.MovieOffer currentOffer = movieOffersResponse.get(i);

                if (currentOffer.isAvailable()) {
                    MovieOffer movieOffer = new MovieOffer(currentOffer.getMovieId());
                    movieOffer.setPrice(currentOffer.getPrice());
                    movieOfferMap.put(currentOffer.getMovieId(), movieOffer);
                }
            }

            List<com.example.movieapp.model.MovieData> movieDataResponse = videoDataResponse.getMovieData();
            for (int i = 0; i < movieDataResponse.size(); i++) {
                MovieOffer movieOffer = movieOfferMap.get(movieDataResponse.get(i).getMovieId());
                if (movieOffer != null) {
                    movieOffer.setSubTitle(movieDataResponse.get(i).getSubTitle());
                    movieOffer.setTitle(movieDataResponse.get(i).getTitle());

                    movieOffers.add(movieOffer);
                }
            }

            return saveToDB(movieOffers);
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> {
                    //TODO handle error
                })
                .subscribe();
    }


    private Disposable saveToDB(List<MovieOffer> movieOffers) {
        return Completable.fromAction(() -> movieOfferDao.insertAllMovieOffers(movieOffers))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }
}