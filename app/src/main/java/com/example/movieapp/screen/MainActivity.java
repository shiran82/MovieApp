package com.example.movieapp.screen;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.viewmodel.MovieOfferViewModel;
import com.example.movieapp.R;
import com.example.movieapp.adapter.MovieOfferListAdapter;
import com.example.movieapp.database.MovieOffer;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MovieOfferViewModel movieOfferViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final MovieOfferListAdapter adapter = new MovieOfferListAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        movieOfferViewModel = ViewModelProviders.of(this).get(MovieOfferViewModel.class);

        movieOfferViewModel.getAllMovieOffers().observe(this, new Observer<List<MovieOffer>>() {
            @Override
            public void onChanged(@Nullable final List<MovieOffer> movieOffers) {
                // Update the cached copy of the movieOffers in the adapter.
                Log.e("test", "on change called");
                adapter.setMovieOffers(movieOffers);
            }
        });

//        movieOfferViewModel.fetchAllMovieOffers();

//        movieOfferViewModel.getAllMovieData().observe(this, new Observer<List<MovieData>>() {
//            @Override
//            public void onChanged(List<MovieData> movieOffers) {
//
//            }
//        });
    }
}
