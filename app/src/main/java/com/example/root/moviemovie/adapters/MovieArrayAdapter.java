package com.example.root.moviemovie.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.moviemovie.R;
import com.example.root.moviemovie.models.Movie;

import java.util.List;

public class MovieArrayAdapter extends ArrayAdapter<Movie>{
    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1 , movies);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Movie movie = getItem(position);

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            inflater.inflate(R.layout.item_movie, parent, false);
        }

        ImageView ivMovie = (ImageView) convertView.findViewById(R.id.iv);
        ivMovie.setImageResource(0);

        TextView title = (TextView) convertView.findViewById(R.id.tvTitre);
        title.setText(movie.getOriginalTitle());

        TextView desc = (TextView) convertView.findViewById(R.id.tvDesc);
        desc.setText(movie.getOverview());

       // Picasso.with(getContext()).load(movie.getPosterPath()).into(ivMovie);

        return convertView;


    }
}
