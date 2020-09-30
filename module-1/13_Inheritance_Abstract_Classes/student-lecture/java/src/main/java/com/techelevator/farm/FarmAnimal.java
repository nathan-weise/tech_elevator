package com.techelevator.farm;

public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private boolean asleep;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	public String getName( ) {

		return name;
	}
	public final String getSound( ) {
		if (asleep) {
			return "zzz";
		} else {
			return sound;
		}
	}

	public boolean isAsleep() {
		return asleep;
	}

	public void setAsleep(boolean asleep) {
		this.asleep = asleep;
	}
	public abstract String eat();
}