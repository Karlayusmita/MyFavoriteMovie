package com.example.myfavoritemovie.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieFavorite implements Parcelable {
    public static final Creator<MovieFavorite> CREATOR = new Creator<MovieFavorite>() {
        @Override
        public MovieFavorite createFromParcel(Parcel in) {
            return new MovieFavorite(in);
        }

        @Override
        public MovieFavorite[] newArray(int size) {
            return new MovieFavorite[size];
        }
    };
    private int id;
    private String poster;
    private String title;
    private String originalLanguage;
    private String releaseDate;
    private String overview;
    private int voteAverage;

    public MovieFavorite(int id, String poster, String title, String originalLanguage, String releaseDate, String overview, int voteAverage) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.poster = poster;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.originalLanguage = originalLanguage;
    }

    protected MovieFavorite(Parcel in) {
        this.id = in.readInt();
        this.poster = in.readString();
        this.title = in.readString();
        this.originalLanguage = in.readString();
        this.releaseDate = in.readString();
        this.overview = in.readString();
        this.voteAverage = in.readInt();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(int voteAverage) {
        this.voteAverage = voteAverage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.poster);
        parcel.writeString(this.title);
        parcel.writeString(this.originalLanguage);
        parcel.writeString(this.releaseDate);
        parcel.writeString(this.overview);
        parcel.writeInt(this.voteAverage);
    }
}
