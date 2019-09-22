package com.example.movieapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;
import com.example.movieapp.database.MovieOffer;

import java.util.List;

public class MovieOfferListAdapter extends RecyclerView.Adapter<MovieOfferListAdapter.MovieOfferViewHolder> {

    private final LayoutInflater inflater;
    private List<MovieOffer> movieOffers; // Cached copy of words

    public MovieOfferListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MovieOfferViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item, parent, false);

        return new MovieOfferViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieOfferViewHolder holder, int position) {
        if (movieOffers != null) {
            MovieOffer current = movieOffers.get(position);
            holder.titleTextView.setText(current.getTitle());
            holder.subTitleTextView.setText(current.getSubTitle());
            holder.priceTextView.setText(current.getPrice());
        }
    }

    public void setMovieOffers(List<MovieOffer> movieOffers) {
        this.movieOffers = movieOffers;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (movieOffers != null) {
            return movieOffers.size();
        }

        return 0;
    }

    class MovieOfferViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTextView;
        private final TextView subTitleTextView;
        private final TextView priceTextView;

        private MovieOfferViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textViewTitle);
            subTitleTextView = itemView.findViewById(R.id.textViewSubTitle);
            priceTextView = itemView.findViewById(R.id.textViewPrice);
        }
    }
}