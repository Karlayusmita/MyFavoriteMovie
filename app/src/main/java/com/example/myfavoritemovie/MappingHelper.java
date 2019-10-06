package com.example.myfavoritemovie;

import android.database.Cursor;

import com.example.myfavoritemovie.model.MovieFavorite;

import java.util.ArrayList;

public class MappingHelper {
    private static final String ID = "id";
    private static final String POSTER = "poster";
    private static final String TITLE = "title";
    private static final String ORIGINAl_LANGUAGE = "original_language";
    private static final String RELEASE_DATE = "release_date";
    private static final String OVERVIEW = "overview";
    private static final String VOTE_AVERAGE = "vote_average";

    public static ArrayList<MovieFavorite> mapCursorToArrayList(Cursor notesCursor) {
        ArrayList<MovieFavorite> movieList = new ArrayList<>();

        while (notesCursor.moveToNext()) {
            int id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(ID));
            String poster = notesCursor.getString(notesCursor.getColumnIndexOrThrow(POSTER));
            String title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(TITLE));
            String originalLanguage = notesCursor.getString(notesCursor.getColumnIndexOrThrow(ORIGINAl_LANGUAGE));
            String releaseDate = notesCursor.getString(notesCursor.getColumnIndexOrThrow(RELEASE_DATE));
            String overview = notesCursor.getString(notesCursor.getColumnIndexOrThrow(OVERVIEW));
            int voteAverage = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(VOTE_AVERAGE));
            movieList.add(new MovieFavorite(id, poster, title, originalLanguage, releaseDate, overview, voteAverage));
        }


        return movieList;
    }
}
