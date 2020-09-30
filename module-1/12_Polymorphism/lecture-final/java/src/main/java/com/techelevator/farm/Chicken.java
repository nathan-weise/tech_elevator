package com.techelevator.farm;

import java.math.BigDecimal;

public class Chicken extends FarmAnimal {

	private static final BigDecimal STANDARD_CHICKEN_PRICE = new BigDecimal("5.25");

	public Chicken() {
		super("Chicken", "cluck!");

	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

	@Override
	public BigDecimal getPrice() {
		return STANDARD_CHICKEN_PRICE;
	}

}