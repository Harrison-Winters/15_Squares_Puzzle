package com.example.a15squarespuzzle;

import android.graphics.Color;
import android.view.View;

import java.util.Arrays;

public class PuzzleController implements View.OnClickListener{
    private PuzzleModel currPuzzleModel;
    private PuzzleView currPuzzleView;

    public PuzzleController(PuzzleView refPuzzleView) {
        this.currPuzzleView = refPuzzleView;
        this.currPuzzleModel = this.currPuzzleView.getPuzzleModel();
    }

    /**
     * Built-in onClick method, modifies view when Clicked
     * In this case it swaps the empty tile and clicked tile when applicable
     * @param view
     * @return void
     */

    @Override
    public void onClick(View view)
    {
        //Initially set the position of the clicked tiles to (0,0)
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
        //and swap tiles if that's the case

        //Above
        if (selectRow != 0 && currPuzzleView.tiles2D[selectRow - 1][selectCol].getText().equals("")) {
            String temp = (String) currPuzzleView.tiles2D[selectRow][selectCol].getText();
            currPuzzleView.tiles2D[selectRow][selectCol].setText("");
            currPuzzleView.tiles2D[selectRow - 1][selectCol].setText(temp);
        }

        //Below
        else if (selectRow != currPuzzleView.tiles2D.length - 1 && currPuzzleView.tiles2D[selectRow + 1][selectCol].getText().equals("")) {
            String temp = (String) currPuzzleView.tiles2D[selectRow][selectCol].getText();
            currPuzzleView.tiles2D[selectRow][selectCol].setText("");
            currPuzzleView.tiles2D[selectRow + 1][selectCol].setText(temp);
        }

        //Left
        else if (selectCol != 0 && currPuzzleView.tiles2D[selectRow][selectCol - 1].getText().equals("")) {
            String temp = (String) currPuzzleView.tiles2D[selectRow][selectCol].getText();
            currPuzzleView.tiles2D[selectRow][selectCol].setText("");
            currPuzzleView.tiles2D[selectRow][selectCol - 1].setText(temp);
        }

        //Right
        else if (selectCol != currPuzzleView.tiles2D[0].length - 1 && currPuzzleView.tiles2D[selectRow][selectCol + 1].getText().equals("")) {
            String temp = (String) currPuzzleView.tiles2D[selectRow][selectCol].getText();
            currPuzzleView.tiles2D[selectRow][selectCol].setText("");
            currPuzzleView.tiles2D[selectRow][selectCol + 1].setText(temp);
        }

        //Once the swapping has occurred, reset the background colors of the tiles
        currPuzzleView.setTileColors(currPuzzleView.tiles2D);



        //If the correct solution is found, set the background of the current TextView to Red
       String[][] checkArray = {{"", " 1", " 2", " 3"}, {" 4", " 5", " 6", " 7"}, {" 8", " 9", "10", "11"}, {"12", "13",
               "14", "15"}};

        if (Arrays.equals(currPuzzleView.tiles2D, checkArray)) {
            view.setBackgroundColor(Color.RED);
        }

    }
}
