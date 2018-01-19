package com.Apptrics.MoviesGridView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by y2k2015 on 1/13/2018.
 */

public class MoviesListAdapter extends BaseAdapter {
    Context context;
    List<Result> moviesList;
    String IMAGE_BASE_URl = "http://image.tmdb.org/t/p/w185";

    MoviesListAdapter(Context context, List<Result> moviesList) {
        this.context = context;
        this.moviesList = moviesList;
        Log.d("TAG", "Inside Const Image List--" + moviesList.size());
    }


    @Override
    public int getCount() {
        return moviesList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        view = inflater.inflate(R.layout.snippet_movies_row, null); // inflate the layout
        ImageView icon = view.findViewById(R.id.Movie_image); // get the reference of ImageView
        Log.d("TAG", "getView Image List--" + moviesList.size());
        if (moviesList.get(i).getPosterPath() != null)
            Picasso.with(context).load(IMAGE_BASE_URl + moviesList.get(i).getPosterPath()).into(icon);

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putParcelable("poster",moviesList.get(i));
                Intent in = new Intent(context,MovieDetailsActivity.class);
                in.putExtras(b);
                context.startActivity(in);
            }
        });
        return view;
    }
}
