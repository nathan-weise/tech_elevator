package com.techelevator.farm;

public final class Cat extends FarmAnimal {

    public Cat() {
        super("Cat", "meow");
        asleep = true;
    }

    @Override
    public String eat() {
        return "Eating the mice.";
    }

// Can't do this because it's final.
//    @Override
//    public String getSound() {
//        return "purr purr meow purr purr";
//    }


}
