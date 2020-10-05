package com.techelevator;

public class MysteriousDevice {


    private int currentFrequency = 0;


    public int getCurrentFrequency() {
        return currentFrequency;
    }

    public void adjustFrequency(int adjustment) {
        currentFrequency += adjustment;
    }

    public void adjustFrequency(int[] adjustments) {
        for (int adjustment : adjustments) {
            adjustFrequency(adjustment);
        }
    }



}
