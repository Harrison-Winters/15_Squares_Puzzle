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
    public void onClick(View view)
    {
        int selectRow = 0;
        int selectCol = 0;
        //Find view in tiles2D array
        for (int r = 0; r < currPuzzleView.tiles2D.length; r++) {
            for (int c = 0; c < currPuzzleView.tiles2D[0].length; c++){
                if (view.equals(currPuzzleView.tiles2D[r][c])) {
                    selectRow = r;
                    selectCol = c;
                }
            }
        }

        //Check if the empty Square is next to the selected tile
        if (selectRow != 0 && currPuzzleView.tiles2D[selectRow - 1][selectCol].getText().equals("")) {
            String temp = (String) currPuzzleView.tiles2D[selectRow][selectCol].getText();
            currPuzzleView.tiles2D[selectRow][selectCol].setText("");
            currPuzzleView.tiles2D[selectRow - 1][selectCol].setText(temp);
        }

        currPuzzleView.setTileColors(currPuzzleView.tiles2D);

       // view.setBackgroundColor(Color.RED);
    }
}
