package com.Apptrics.MoviesGridView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.Apptrics.MoviesGridView.API.APIRequest;
import com.Apptrics.MoviesGridView.API.RequestCallBack;

import com.google.gson.Gson;

import java.util.List;

public class MoviesListActivity extends AppCompatActivity {

    GridView moviesGridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);
        moviesGridView = findViewById(R.id.movies_grid);
        callMoviesAPI();
    }

    void callMoviesAPI() {
        new APIRequest(MoviesListActivity.this).get("movie/popular?api_key=Your API Key", null, new RequestCallBack() {
            @Override
            public void onResponse(String jsonObject) {
                Log.d("Movies", "Success message--" + jsonObject);
                Gson gson = new Gson();
                if (jsonObject != null) {
                    MovieListModel movieListModel = gson.fromJson(jsonObject, MovieListModel.class);
                    if (movieListModel != null && movieListModel.getResults() != null) {
                        Log.d("TAG", "Activity Image List--" + movieListModel.getResults().size()+movieListModel.getResults().get(0).getTitle());

                        setGridAdapter(movieListModel.getResults());
                    }
                }

            }

            @Override
            public void onFailed(String message) {
                Log.d("movies", "Error message--" + message);
            }
        });
    }

    void setGridAdapter(List<Result> moviesList) {
        MoviesListAdapter moviesListAdapter = new MoviesListAdapter(MoviesListActivity.this, moviesList);
        moviesGridView.setAdapter(moviesListAdapter);
    }

}
