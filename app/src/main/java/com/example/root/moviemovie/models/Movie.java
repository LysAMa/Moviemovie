package com.example.root.moviemovie.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Movie {
    String posterPath;
    String originalTitle;
    String overview;

    public Movie(JSONObject jsonObject) throws JSONException{
        this.posterPath = jsonObject.getString("poster_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
    }

    public static ArrayList<Movie> fromJSONarray(JSONArray array){
        ArrayList<Movie> results = new ArrayList<>();

        for(int x=0; x<array.length(); x++ ){
            try {
                new Movie(array.getJSONObject(x));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }
}
