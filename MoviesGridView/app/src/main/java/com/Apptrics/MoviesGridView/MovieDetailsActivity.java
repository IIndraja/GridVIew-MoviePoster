package com.Apptrics.MoviesGridView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {
    TextView tvTitle,tvYear,tvDuration,tvDesc;
    ImageView imgPoster;
    String IMAGE_BASE_URl = "http://image.tmdb.org/t/p/w185";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        tvTitle = findViewById(R.id.tv_movie_name);
        imgPoster = findViewById(R.id.img_poster);
        tvDesc = findViewById(R.id.tv_movie_desc);

        if(getIntent()!=null && getIntent().getExtras()!=null){
            Bundle b = getIntent().getExtras();
            Result movieDetails = b.getParcelable("poster");
            tvTitle.setText(movieDetails.getTitle());
            tvDesc.setText(movieDetails.getOverview());
            if (movieDetails.getPosterPath() != null)
                Picasso.with(MovieDetailsActivity.this).load(IMAGE_BASE_URl +movieDetails.getPosterPath()).into(imgPoster);
        }
    }
}
