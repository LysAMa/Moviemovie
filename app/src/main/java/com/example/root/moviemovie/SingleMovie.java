package com.example.root.moviemovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SingleMovie extends AppCompatActivity {
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_movie);
        if (getIntent().getExtras() != null){
            position = getIntent().getIntExtra("pos",0);
        }
    }
    public void onSubmit(View v) {
        Intent data = new Intent();
        data.putExtra("position", position);
        setResult(RESULT_OK, data);
        this.finish();
    }
}
