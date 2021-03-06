package com.example.root.moviemovie.adapters;

import android.content.Context;
import android.content.res.Configuration;
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
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class MovieArrayAdapter extends ArrayAdapter<Movie>{
    private static class ViewHolder {
        ImageView ivImage;
        TextView title;
        TextView desc;
    }

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1 , movies);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Movie movie = getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tvTitre);
            viewHolder.ivImage = (ImageView) convertView.findViewById(R.id.ivMovie);
            viewHolder.desc = (TextView) convertView.findViewById(R.id.tvDesc);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.ivImage.setImageResource(0);

        int orientation = getContext().getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Picasso.with(getContext()).load(movie.getPosterPath()).fit().centerCrop().placeholder(R.drawable.ic_launcher_background).transform(new RoundedCornersTransformation(10, 10)).into(viewHolder.ivImage);
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Picasso.with(getContext()).load(movie.getBackdrop()).fit().centerCrop().placeholder(R.drawable.ph).transform(new RoundedCornersTransformation(10, 10)).into(viewHolder.ivImage);

        }


        viewHolder.title.setText(movie.getOriginalTitle());
        viewHolder.desc.setText(movie.getOverview());


        return convertView;


    }
}
