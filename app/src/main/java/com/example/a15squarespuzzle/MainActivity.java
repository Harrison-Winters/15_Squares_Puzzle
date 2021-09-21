package com.example.a15squarespuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find Buttons
        View reset = (View) findViewById(R.id.reset);
        setContentView(R.layout.activity_main);

        PuzzleView puzzleView = (PuzzleView) findViewById(R.id.puzzleView);
        PuzzleController CakeController = new PuzzleController(puzzleView);

        //Set listener
         reset.setOnClickListener(puzzleView);


    }
}
