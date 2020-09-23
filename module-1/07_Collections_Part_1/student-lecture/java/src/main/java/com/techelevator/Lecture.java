package com.techelevator;

import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecture {

	//1. returnsAnArray(5) -> {1, 2, 3, 4, 5}
	public int[] returnsAnArray(int number) {
		int[] result = new int[number];
		for (int i = 0; i < number; i++) {
			result[i] = i + 1;
		}
		return result;
	}

	//2. returnsAList(5) -> [1, 2, 3, 4, 5]
	public List<Integer> returnsAList(int number) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			result.add(i +1 );
		}
		return result;
	}

	//3. returnThirdName(["Frodo","Sam","Merry","Pippin"]) -> "Merry"
	public String returnThirdName(List<String> names) {
		return names.get(2);
	}

	//4. insertAfterFirst(["Luke","Leia"], "Han") -> ["Luke", "Han", "Leia"]
	public List<String> insertAfterFirst(List<String> names, String name) {
		List<String> result = new ArrayList<>(names);
		result.add(1,name);
		return result;
	}

	//5. onlyOneAnswer(["yes", "no", "maybe"]) -> false
	//   onlyOneAnswer(["no"]) -> true
	public boolean onlyOneAnswer(List<String> answers) {
		if (answers.size() >1) {
			return false;
 		}
		return true;
	}

	//6. removeLastNumber([1.5, 2.2, 0.9]) -> [1.5, 2.2]
	public List<Double> removeLastNumber(List<Double> numbers) {
		List<Double> result = new ArrayList<>(numbers);
		result.remove(result.size() -1 );
		return result;
	}

	//7. hasACow(["duck","cow","chicken"]) -> true
	//   hasACow(["turkey", "rooster"]) -> false
	public boolean hasACow(List<String> farmAnimals) {
		return farmAnimals.contains("cow");
	}

	//8. yourPlaceInLine(["customer","customer","you","customer"]) -> 3
	public int yourPlaceInLine(List<String> allCustomers) {
		int you = allCustomers.indexOf("you");
		return you + 1;
	}

	//9. trimArray({"a","b","c","d"}) -> {"b","c"}
	public String[] trimArray(String[] input) {
		List<String> copy = new ArrayList<>(Arrays.asList(input));
		copy.remove(0);
		copy.remove(copy.size() -1);
		String[] result = copy.toArray(new String[0]);
		return result;
	}

	//10. descendingOrder([3, 4, 2, 9, 4, 8]) -> [9, 8, 4, 4, 3, 2]
	public List<Integer> descendingOrder(List<Integer> numbers) {
		List<Integer> result = new ArrayList<>(numbers);
		Collections.sort(result);
		Collections.reverse(result);
		return result;
	}

	//11. countTrues([false,true,true,false,true]) -> 3
	public int countTrues(List<Boolean> answers) {
		return -1;
	}

	//12. incrementAll([100, 17, 33]) -> [101, 18, 34]
	public List<Integer> incrementAll(List<Integer> numbers) {
		return null;
	}

	//13. echo(["Tech","Elevator"]) -> ["Tech","Tech","Elevator","Elevator"]
	public List<String> echo(List<String> words) {
		return null;
	}

}
