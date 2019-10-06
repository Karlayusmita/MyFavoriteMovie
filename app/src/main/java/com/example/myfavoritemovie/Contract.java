package com.example.myfavoritemovie;

import android.net.Uri;

public class Contract {
    private static final String CONTENT_AUTHORITY = "com.example.mymoviecatalougesub5";
    private static final String TABLE_TASKS = "tasks";

    public static final Uri CONTENT_URI = new Uri.Builder().scheme("content")
            .authority(CONTENT_AUTHORITY)
            .appendPath(TABLE_TASKS)
            .build();
}
