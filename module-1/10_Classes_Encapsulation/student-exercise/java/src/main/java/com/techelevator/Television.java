package com.techelevator;

public class Television {

    private boolean on = false;
    private int currentChannel = 3;
    private int currentVolume = 2;

    public boolean isOn() {
        return on;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void turnOff() {
        if (on) {
            on = false;
        }
    }

    public void turnOn() {
        on = true;
    }

    public void changeChannel(int newChannel) {

    }

    public void channelUp() {

    }

    public void channelDown() {

    }

    public void raiseVolume() {

    }

    public void lowerVolume() {

    }

}
