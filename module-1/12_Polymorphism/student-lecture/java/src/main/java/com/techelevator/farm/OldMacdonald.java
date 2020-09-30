package com.techelevator.farm;

import java.math.BigDecimal;

public class OldMacdonald {
	public static void main(String[] args) {

		Cow bossy = new Cow();
		bossy.setPrice(new BigDecimal("50"));

		Cow angus = new Cow();
		angus.setPrice(new BigDecimal("100"));

		Singable[] songThings = new Singable[] { bossy, angus, new Chicken(), new Goat(), new Tractor() };

		for (Singable songThing : songThings) {
			String name = songThing.getName();
			String sound = songThing.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] merchandise = new Sellable[] {bossy, angus, new Egg()};

		for (Sellable item : merchandise) {
			System.out.println("And that " + item.getName() + " can be yours " + item.getPrice() + " dollars");
		}


		FarmAnimal critter = new Chicken();
		System.out.println(critter.getSound());

		System.out.println(critter instanceof Cow);



		System.out.println(0.1 + 0.2);

		BigDecimal first = new BigDecimal("0.1");
		BigDecimal second = new BigDecimal("0.2");
		System.out.println(first.add(second));

		BigDecimal myNumber = BigDecimal.ZERO;
		myNumber = myNumber.add(second);
		myNumber = myNumber.add(second);



		BigDecimal price = critter.getPrice();
		myNumber = myNumber.add(price);
		System.out.println(myNumber);

		if (first.compareTo(second) > 0) {
			System.out.println("first is bigger");
		}
	}
}