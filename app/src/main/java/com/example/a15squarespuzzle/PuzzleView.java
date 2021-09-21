package com.example.a15squarespuzzle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class PuzzleView implements View.OnClickListener{

    private PuzzleModel puzzleInfo;
    private Activity activity;

   private TextView[] tiles;




    //public TextView[] tiles = {Col0Row0,Col1Row0, Col2Row0, Col3Row0, Col0Row1,Col1Row1, Col2Row1,Col3Row1,
       //     Col0Row2, Col1Row2, Col2Row2, Col3Row2, Col0Row3, Col1Row3, Col2Row3, Col3Row3};

    public PuzzleView(Activity mainActivity) {
        this.activity = mainActivity;

        //Initialize Model instance
        puzzleInfo = new PuzzleModel();

        tiles = new TextView[16];
        //Find TextViews
        tiles[0] = (TextView)activity.findViewById(R.id.Col0Row0);
        tiles[1] = (TextView)activity.findViewById(R.id.Col1Row0);
        tiles[2] = (TextView)activity.findViewById(R.id.Col2Row0);
        tiles[3] = (TextView)activity.findViewById(R.id.Col3Row0);
        tiles[4] = (TextView)activity.findViewById(R.id.Col0Row1);
        tiles[5] = (TextView)activity.findViewById(R.id.Col1Row1);
        tiles[6] = (TextView)activity.findViewById(R.id.Col2Row1);
        tiles[7] = (TextView)activity.findViewById(R.id.Col3Row1);
        tiles[8] = (TextView)activity.findViewById(R.id.Col0Row2);
        tiles[9] = (TextView)activity.findViewById(R.id.Col1Row2);
        tiles[10] = (TextView)activity.findViewById(R.id.Col2Row2);
        tiles[11] = (TextView)activity.findViewById(R.id.Col3Row2);
        tiles[12] = (TextView)activity.findViewById(R.id.Col0Row3);
        tiles[13] = (TextView)activity.findViewById(R.id.Col1Row3);
        tiles[14] = (TextView)activity.findViewById(R.id.Col2Row3);
        tiles[15] = (TextView)activity.findViewById(R.id.Col3Row3);


    }



    public PuzzleModel getPuzzleModel() {
        return puzzleInfo;
    }

    @Override
    public void onClick(View view) {

        //Shuffle an array with Strings representing the values of each tile

        String[] values =  {"", " 1", " 2"," 3"," 4"," 5"," 6"," 7"," 8"," 9","10", "11", "12", "13",
                "14", "15"};

        Random rnd = new Random();

        for (int i = values.length - 1; i >0; i--) {
            int index = rnd.nextInt(i + 1);
            String p = values[index];
            values[index] = values[i];
            values[i] = p;
        }



        //transfer tile values into the PuzzleModel

        for (int i = 0; i < values.length - 1; i++) {

            puzzleInfo.tileValues[i] = values[i];
        }


        //Tell View to redraw
        //invalidate();

        //Set text of Textviews

        for (int i = 0; i < 15; i++) {
            tiles[i].setText(puzzleInfo.tileValues[i]);


        }


    }


}
