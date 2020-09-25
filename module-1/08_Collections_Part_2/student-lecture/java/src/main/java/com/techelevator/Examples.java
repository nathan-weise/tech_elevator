package com.techelevator;

import java.util.*;

public class Examples {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(10);
        numbers.add(4896);
        numbers.add(10);
        System.out.println(numbers);

       /* Set<Integer> moreNumbers = new HashSet<>();
        moreNumbers.add(12);
        moreNumbers.add(10);
        moreNumbers.add(4096);
        moreNumbers.add(10);
        System.out.println(moreNumbers); */

        Set<Integer> moreNumbers = new TreeSet<>();
        moreNumbers.add(12);
        moreNumbers.add(10);
        moreNumbers.add(4096);
        moreNumbers.add(10);
        System.out.println(moreNumbers);

        Map<Integer, String> musicGroups = new HashMap<>();
        musicGroups.put(2, "duo");
        musicGroups.put(3, "trio");
        musicGroups.put(4, "quartet");

        String groupOf3 = musicGroups.get(3);
        String groupOf4 = musicGroups.get(4);
        System.out.println(groupOf3 + " " + groupOf4);

        System.out.println("Does groups contain a key of 3? " + musicGroups.containsKey(3));
        System.out.println("Does groups contain a value of duo? " + musicGroups.containsValue("duo"));

        System.out.println(musicGroups.keySet());

        //System.out.println(musicGroups.entrySet());
        //for (Map.Entry<Integer,String>) currentEntry : musicGroups.entrySet();

    }
}
