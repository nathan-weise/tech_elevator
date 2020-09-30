package com.techelevator.farm;

import java.math.BigDecimal;

public class FarmAnimal implements Singable, Sellable {

	private static final BigDecimal DEFAULT_PRICE = BigDecimal.TEN;

	private String name;
	private String sound;
	private BigDecimal price;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
		price = DEFAULT_PRICE;
	}

	public String getName() {
		return name;
	}

	public String getSound() {
		return sound;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}