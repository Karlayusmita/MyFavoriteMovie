package com.example.myfavoritemovie.activity;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.myfavoritemovie.R;
import com.example.myfavoritemovie.adapter.MovieAdapter;
import com.example.myfavoritemovie.model.MovieFavorite;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.myfavoritemovie.Contract.CONTENT_URI;
import static com.example.myfavoritemovie.MappingHelper.mapCursorToArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ArrayList<MovieFavorite> arrayList;
    private MovieAdapter listMovieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view_movie);
        progressBar = findViewById(R.id.progress_bar_movie);

        showRecyclerList();
        if (savedInstanceState == null) {
            loadData();
        } else {
            arrayList = savedInstanceState.getParcelableArrayList("list");
            if (arrayList != null) {
                listMovieAdapter.setMovieArrayList(arrayList);
            }
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("list", arrayList);
    }

    private void loadData() {
        new MovieAsyncTask().execute();
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listMovieAdapter = new MovieAdapter(this);
        recyclerView.setAdapter(listMovieAdapter);
        listMovieAdapter.setMovieArrayList(arrayList);
    }

    public class MovieAsyncTask extends AsyncTask<Void, Void, Cursor> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
        }

        @Override
        protected Cursor doInBackground(Void... voids) {
            return getContentResolver().query(CONTENT_URI, null, null, null, null);
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            super.onPostExecute(cursor);
            recyclerView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);

            arrayList = mapCursorToArrayList(cursor);
            listMovieAdapter.setMovieArrayList(arrayList);
        }
    }

}
