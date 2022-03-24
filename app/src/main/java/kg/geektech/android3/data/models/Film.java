package kg.geektech.android3.data.models;

import com.google.gson.annotations.SerializedName;

public class Film {
    String id;
    String title;
    String director;
    String producer;
    @SerializedName("movie_banner")
    String movieBanner;
    @SerializedName("original_title")
    String originalTitle;
    String description;
    @SerializedName("release_date")
    String releaseDate;

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getDescription() {
        return description;
    }
    public String getMovieBanner() {
        return movieBanner;
    }

}
