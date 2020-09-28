package com.techelevator;

public class FruitTree {

    private String typeOfFruit;
    private int startingPiecesOfFruit;
    private int piecesOfFruitLeft;
    private Boolean pickFruit = false;

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }

    public int getStartingPiecesOfFruit() {
        return startingPiecesOfFruit;
    }

    public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
        this.typeOfFruit = typeOfFruit;
        this.startingPiecesOfFruit = startingPiecesOfFruit;
        piecesOfFruitLeft = startingPiecesOfFruit;
    }

    public boolean pickFruit(int numberOfPiecesToRemove) {
        if (numberOfPiecesToRemove <= piecesOfFruitLeft) {
            piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;
            return true;

        } else {
            return false;
        }
    }
}

