package com.example.assignmenttmdbapiunittest.api.interfaces;

import com.example.assignmenttmdbapiunittest.api.model.Movie;
import com.example.assignmenttmdbapiunittest.api.model.Reviews;
import com.example.assignmenttmdbapiunittest.api.model.Videos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface MovieInterface {


    @GET("top_rated?")
    Call<Movie> getTopRatedMovies();

    @GET("popular?")
    Call<Movie> getPopularMovies();

    @GET("{id}/videos")
    Call<Videos> getMovieVideos(@Path("id") int movieId);

    @GET("{id}/reviews")
    Call<Reviews> getMovieReviews(@Path("id") int movieId);
}
