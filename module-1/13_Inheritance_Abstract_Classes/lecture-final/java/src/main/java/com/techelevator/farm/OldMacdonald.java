package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		Pig wilbur = new Pig();
		wilbur.setAsleep(true);

		Cat nyanCat = new Cat();
		nyanCat.setAsleep(true);


		Singable[] singables =
				new Singable[] {new Cow(), new Chicken(), wilbur, new Tractor(), nyanCat};

		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] {new Cow(), new Pig(), new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}

		//FarmAnimal abomination = new FarmAnimal(); //Can't because it is abstract!

		FarmAnimal animal = new Cow();
		animal = new Chicken();


	}
}