package com.techelevator;

import java.util.*;

public class Lecture {

    //1. removeDuplicates([1,2,1,1,2,1,2]) -> [1,2] or [2,1]
    public List<Integer> removeDuplicates(List<Integer> input) {
        Set<Integer> noExtra = new HashSet<>(input);
        return new ArrayList<>(noExtra);
    }

    //2. musicalGroupNames() -> {2="duo",3="trio",4="quartet"}
    public Map<Integer,String> musicalGroupNames() {
        Map<Integer,String> result  = new HashMap<>();
        result.put(2, "duo");
        result.put(3, "trio");
        result.put(4, "quartet");
        return result;
    }

    //3. coinValues() -> {"penny"=1,"nickel"=5,"dime"=10,"quarter"=25}
    public Map<String,Integer> coinValues() {
        Map<String,Integer> change = new HashMap<>();
        change.put("penny", 1);
        change.put("nickel", 5);
        change.put("dime", 10);
        change.put("quarter", 25);
        return change;
    }

    //4. describeGroup(3, "violin") -> "violin trio"
    //   describeGroup(0, "trumpet") -> "trumpet group"
    public String describeGroup(int count, String instrument) {
       Map<Integer,String> groups = musicalGroupNames();
       String groupName = groups.get(count);
       if (groupName == null) {
           groupName = "group";
       }
       return instrument + " " + groupName;
    }

    //5. totalCents({"nickel","quarter","penny","penny"}) -> 32
    public int totalCents(String[] coins) {
        Map<String,Integer> values = coinValues();
        int total = 0;
        for (String coin : coins) {
            int value = values.get(coin);
            total = total + value;
        }

        return total;
    }

    //6. validCoin("dime") -> "valid"
    //   validCoin("token") -> "invalid"
    public String validCoin(String coin) {
        Map<String,Integer> moneys = coinValues();
        boolean valid = moneys.containsKey(coin);
        String result;
        if (valid) {
            result = "valid";
        } else {
            result = "invalid";
        }
        return result;
    }

    //7. stateNames({"Ohio"="Columbus","Kentucky"="Frankfort","Indiana"="Indianapolis"})
    //             -> ["Ohio","Kentucky","Indiana"]
    public List<String> stateNames(Map<String,String> capitals) {
       Set<String> stateSet = capitals.keySet();
       return new ArrayList<>(stateSet);
    }

    //8. availableColors({"red"=true,"blue"=false,"green"=true,"yellow"=true,"gray"=false})
    //                  -> ["red","green","yellow"]
    public List<String> availableColors(Map<String,Boolean> availability) {
        List<String> result = new ArrayList<>();

        for (Map.Entry<String,Boolean> entry : availability.entrySet()) {
            if (entry.getValue() == true) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    //9. addBonus({"Player 1"=5000,"Player 2"=2500,"Player 3"=4500}, 500)
    //         -> {"Player 1"=5500,"Player 2"=3000,"Player 3"=5000}
    public void addBonus(Map<String,Integer> scores, int bonus) {
        for(Map.Entry<String,Integer> playerScore : scores.entrySet()) {
            int newScore = playerScore.getValue() + bonus;
            playerScore.setValue(newScore);
        }
    }

}
