package com.example.myfavoritemovie.api;

import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;

public class Api {
    public static URL getPoster(String poster_path) {
        // https://image.tmdb.org/t/p/w185/bI37vIHSH7o4IVkq37P8cfxQGMx.jpg
        poster_path = poster_path.startsWith("/") ? poster_path.substring(1) : poster_path;
        Uri uri = Uri.parse("https://image.tmdb.org/t/p/").buildUpon()
                .appendPath("w185")
                .appendPath(poster_path)
                .build();

        URL url = null;
        try {
            url = new URL(uri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
