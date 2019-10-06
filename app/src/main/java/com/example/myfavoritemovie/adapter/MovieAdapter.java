package com.example.myfavoritemovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myfavoritemovie.R;
import com.example.myfavoritemovie.model.MovieFavorite;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private static final String IMG_BASE = "http://image.tmdb.org/t/p/";
    private ArrayList<MovieFavorite> movieArrayList;
    private Context context;

    public MovieAdapter(Context context) {
        this.context = context;
        movieArrayList = new ArrayList<>();
    }

    private ArrayList<MovieFavorite> getMovieArrayList() {
        return movieArrayList;
    }

    public void setMovieArrayList(ArrayList<MovieFavorite> movieArrayList) {
        this.movieArrayList = movieArrayList;
        notifyDataSetChanged();
    }

    private Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new MovieAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        MovieFavorite movie = movieArrayList.get(position);

        Glide.with(holder.itemView.getContext())
                .load(IMG_BASE + "w185" + movie.getPoster())
                .apply(new RequestOptions().override(96, 144))
                .into(holder.poster);
        holder.title.setText(movie.getTitle());
        holder.releaseDate.setText(movie.getReleaseDate());
        holder.voteAverage.setRating((float) movie.getVoteAverage() / 2);
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView title;
        TextView releaseDate;
        RatingBar voteAverage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.item_poster);
            title = itemView.findViewById(R.id.item_title);
            releaseDate = itemView.findViewById(R.id.item_release_date);
            voteAverage = itemView.findViewById(R.id.item_vote);
        }
    }
}
