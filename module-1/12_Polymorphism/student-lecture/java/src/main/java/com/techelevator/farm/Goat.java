package com.techelevator.farm;

public class Goat extends FarmAnimal{

    public Goat() {
        super("Goat", "bleat!");
    }
    @Override
    public String getSound() {
        return "baa baa baa!";
    }
}
