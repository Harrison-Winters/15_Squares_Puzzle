package com.example.a15squarespuzzle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class PuzzleView extends SurfaceView implements View.OnClickListener{

    PuzzleModel puzzleInfo;

    public PuzzleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //Initialize Model instance
        puzzleInfo = new PuzzleModel();
    }



    public PuzzleModel getPuzzleModel() {
        return puzzleInfo;
    }

    @Override
    public void onClick(View view) {

    }
}
