package com.techelevator.farm;

import java.math.BigDecimal;

public class Egg implements Sellable {


    @Override
    public String getName() {
        return "Egg";
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal("2");
    }
}
