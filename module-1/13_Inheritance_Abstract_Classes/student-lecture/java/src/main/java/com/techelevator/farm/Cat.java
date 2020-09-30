package com.techelevator.farm;

public final class Cat extends FarmAnimal {

    public Cat() {
        super("Cat", "meow");
    }

    @Override
    public String eat() {
        return "eating th mice";
    }
}
