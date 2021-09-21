package com.example.a15squarespuzzle;

public class PuzzleController {
    private PuzzleModel currPuzzleModel;
    private PuzzleView currPuzzleView;

    public PuzzleController(PuzzleView refPuzzleView) {
        this.currPuzzleView = refPuzzleView;
        this.currPuzzleModel = this.currPuzzleView.getPuzzleModel();
    }



}
