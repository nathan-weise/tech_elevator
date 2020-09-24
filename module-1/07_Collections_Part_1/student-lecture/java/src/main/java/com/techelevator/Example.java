package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example {

    public static void main(String[] args) {

        List<String> iceCreamTypes = new ArrayList<>();
        iceCreamTypes.add("cow milk");
        iceCreamTypes.add("soy milk");
        iceCreamTypes.add("almond milk");
        iceCreamTypes.add("coconut milk");

        for (int i = 0; i < iceCreamTypes.size(); i++) {
            String variety = iceCreamTypes.get(i);
            variety = variety.replace("milk", "");
            System.out.println(iceCreamTypes);
        }

        for (int i = 0; i < iceCreamTypes.size(); i++) {
            String variety = iceCreamTypes.get(i);
            System.out.println(variety);
        }
        // ^^^ this equals that ^^^
        for (String variety : iceCreamTypes) {
            System.out.println(variety);
        }

        List<String> iceCreamFlavors = new ArrayList<>(Arrays.asList("chocolate", "vanilla"));

        for (String flavor : iceCreamFlavors) {
            for (String variety : iceCreamFlavors) {
                System.out.println(flavor + " " + variety);

            }
        }

    }
}
