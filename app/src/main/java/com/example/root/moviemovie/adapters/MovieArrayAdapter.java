package com.example.root.moviemovie.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.root.moviemovie.models.Movie;

import java.util.List;

public class MovieArrayAdapter extends ArrayAdapter<Movie>{
    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1 , movies);
    }
}
