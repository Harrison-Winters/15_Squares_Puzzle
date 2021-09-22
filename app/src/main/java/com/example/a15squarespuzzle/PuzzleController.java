package com.example.a15squarespuzzle;

import android.graphics.Color;
import android.view.View;

public class PuzzleController implements View.OnClickListener{
    private PuzzleModel currPuzzleModel;
    private PuzzleView currPuzzleView;

    public PuzzleController(PuzzleView refPuzzleView) {
        this.currPuzzleView = refPuzzleView;
        this.currPuzzleModel = this.currPuzzleView.getPuzzleModel();
    }


    @Override
    public void onClick(View view) {
        view.setBackgroundColor(Color.RED);
    }
}
