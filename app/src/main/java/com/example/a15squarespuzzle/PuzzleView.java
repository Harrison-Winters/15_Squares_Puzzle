package com.example.a15squarespuzzle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PuzzleView implements View.OnClickListener {

    private PuzzleModel puzzleInfo;
    private Activity activity;
    public TextView[] tiles;
    public TextView[][] tiles2D;


    public PuzzleView(Activity mainActivity) {
        this.activity = mainActivity;

        //Initialize Model instance
        puzzleInfo = new PuzzleModel();

        tiles = new TextView[16];
        tiles2D = new TextView[4][4];

        //Find TextViews
        tiles[0] = (TextView) activity.findViewById(R.id.Col0Row0);
        tiles[1] = (TextView) activity.findViewById(R.id.Col1Row0);
        tiles[2] = (TextView) activity.findViewById(R.id.Col2Row0);
        tiles[3] = (TextView) activity.findViewById(R.id.Col3Row0);
        tiles[4] = (TextView) activity.findViewById(R.id.Col0Row1);
        tiles[5] = (TextView) activity.findViewById(R.id.Col1Row1);
        tiles[6] = (TextView) activity.findViewById(R.id.Col2Row1);
        tiles[7] = (TextView) activity.findViewById(R.id.Col3Row1);
        tiles[8] = (TextView) activity.findViewById(R.id.Col0Row2);
        tiles[9] = (TextView) activity.findViewById(R.id.Col1Row2);
        tiles[10] = (TextView) activity.findViewById(R.id.Col2Row2);
        tiles[11] = (TextView) activity.findViewById(R.id.Col3Row2);
        tiles[12] = (TextView) activity.findViewById(R.id.Col0Row3);
        tiles[13] = (TextView) activity.findViewById(R.id.Col1Row3);
        tiles[14] = (TextView) activity.findViewById(R.id.Col2Row3);
        tiles[15] = (TextView) activity.findViewById(R.id.Col3Row3);

        //Set up tiles2D
        tiles2D[0][0] = tiles[0];
        tiles2D[0][1] = tiles[1];
        tiles2D[0][2] = tiles[2];
        tiles2D[0][3] = tiles[3];
        tiles2D[1][0] = tiles[4];
        tiles2D[1][1] = tiles[5];
        tiles2D[1][2] = tiles[6];
        tiles2D[1][3] = tiles[7];
        tiles2D[2][0] = tiles[8];
        tiles2D[2][1] = tiles[9];
        tiles2D[2][2] = tiles[10];
        tiles2D[2][3] = tiles[11];
        tiles2D[3][0] = tiles[12];
        tiles2D[3][1] = tiles[13];
        tiles2D[3][2] = tiles[14];
        tiles2D[3][3] = tiles[15];


        //Create instance of PuzzleControlller
        PuzzleController puzzleC = new PuzzleController(this);


        //Set TextView Listeners

        for (int i = 0; i < tiles.length; i++) {
            tiles[i].setOnClickListener(puzzleC);
        }

    }


    public PuzzleModel getPuzzleModel() {
        return puzzleInfo;
    }


    @Override
    public void onClick(View view) {

        //Initially set all Background Colors to white
        for (int i = 0; i < tiles2D.length; i++) {
            for (int q = 0; q < tiles2D[0].length; q++) {
                tiles2D[i][q].setBackgroundColor(Color.argb(255, 255, 255, 255));
            }
        }


        //Shuffle an array with Strings representing the values of each tile

        List<String> values = Arrays.asList("", " 1", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", "11", "12", "13",
                "14", "15");


        Collections.shuffle(values);





        //transfer tile values into the PuzzleModel
        for (int i = 0; i < values.size() ; i++) {

            puzzleInfo.tileValues[i] = values.get(i);
        }





        //Set text of Textviews

        for (int i = 0; i < values.size(); i++) {
            tiles[i].setText(puzzleInfo.tileValues[i]);


        }

        //Set Background Colors for tiles

        setTileColors(tiles2D);


    }

    public void setTileColors(TextView[][] tiles2D) {

        //find max width

        int max = 0;
        for (int i = 0; i < 16; i++) {
            int curr = tiles[i].getWidth();
            if (curr > max) {
                max = curr;
            }
        }

        //Set Background Colors for Tiles
        for (int i = 0; i < tiles2D.length; i++) {
            for (int q = 0; q < tiles2D[0].length; q++) {


                if (!tiles2D[i][q].getText().equals("")) {
                    tiles2D[i][q].setBackgroundColor(Color.argb(255, 0, i * 20, 255 - (q * 20)));
                    tiles2D[i][q].setWidth(max);
                } else {
                    tiles2D[i][q].setBackgroundColor(Color.WHITE);
                }
            }
        }

    }
}



