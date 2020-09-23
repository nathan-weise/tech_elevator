package com.techelevator;

import java.util.*;

public class Examples {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(10);
        numbers.add(4096);
        numbers.add(10);
        System.out.println(numbers);

        Set<Integer> moreNumbers = new HashSet<>();
        moreNumbers.add(12);
        moreNumbers.add(10);
        moreNumbers.add(4096);
        moreNumbers.add(10);
        System.out.println(moreNumbers);

        Map<Integer,String> groups  = new HashMap<>();
        groups.put(2, "duo");
        groups.put(3, "trio");
        groups.put(4, "quartet");

        String groupOf3 = groups.get(3);
        String groupOf4 = groups.get(4);
        System.out.println(groupOf3 + " " + groupOf4);

        System.out.println("Groups contains a key of 3? " + groups.containsKey(3));
        System.out.println("Groups contains a key of 37? " + groups.containsKey(37));
        System.out.println("Groups contains a value of duo? " + groups.containsValue("duo"));

        System.out.println(groups.keySet());

        Map<String,String> zipCodes = new HashMap<>();
        zipCodes.put("David","45208");
        zipCodes.put("Drew","45069");
        zipCodes.put("Ben","45150");

        System.out.println("Ben's zipcode is: " + zipCodes.get("Ben"));

        zipCodes.put("Ben","45213");
        zipCodes.put("Nathan","45208");

        System.out.println("Ben's zipcode is: " + zipCodes.get("Ben"));
        System.out.println("David's zipcode is: " + zipCodes.get("David"));
        System.out.println("Nathan's zipcode is: " + zipCodes.get("Nathan"));

        System.out.println(zipCodes.entrySet());
        for (Map.Entry<String,String> currentEntry : zipCodes.entrySet()) {
            System.out.println(currentEntry.getValue() +
                                  " is the zip code for " + currentEntry.getKey());
        }

        Map<String,Integer> scores = new HashMap<>();
        scores.put("Player 1", 1000);
        scores.put("Player 2", 2000);

        scores.put("Player 1", 1500);

    }
}
