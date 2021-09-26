package com.example.a15squarespuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
Name: Harrison Winters
Class: CS301
Version Date: 9/25/2021

 */


public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find Button
        View reset = (View) findViewById(R.id.reset);


        PuzzleView puzzleView = new PuzzleView(this);
        PuzzleController CakeController = new PuzzleController(puzzleView);

        //Set listener for Reset Button
        reset.setOnClickListener(puzzleView);




        //Have the Reset Button be pressed at Start Up


        reset.post(new Runnable() {
            @Override
            public void run() {
                reset.performClick();
            }
        });





    }
}
