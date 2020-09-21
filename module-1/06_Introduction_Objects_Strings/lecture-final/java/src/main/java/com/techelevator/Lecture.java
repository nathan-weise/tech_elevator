package com.techelevator;

public class Lecture {

	//1. Return any String
	public String returnsAString() {
		return "";
	}

	//2. getInputLength("abc") -> 3
	public int getInputLength(String input) {
		return input.length();
	}

	//3. getFirst3Letters("abcdef") -> "abc"
	public String getFirst3Letters(String input) {
		return input.substring(0,3);
	}

	//4. getLast3Letters("abcdef") -> "def"
	public String getLast3Letters(String input) {
		int len = input.length();
		return input.substring(len - 3);
	}

	//5. removeFirstLetter("abcdef") -> "bcdef"
	public String removeFirstLetter(String input) {
		return input.substring(1);
	}

	//6. locationOfFirstCat("I have a catalog of cats.") -> 9
	public int locationOfFirstCat(String stringWithCat) {
		return stringWithCat.indexOf("cat");
	}

	//7. locationOfLastCat("I have a catalog of cats.") -> 20
	public int locationOfLastCat(String stringWithCat) {
		return stringWithCat.lastIndexOf("cat");
	}

	//8. getFifthCharacter("abcdef") -> 'e'
	public char getFifthCharacter(String input) {
		return input.charAt(4);
	}

	//9. isCareful("I don't think Voldemort is real.") -> "No"
	//   isCareful("Beware of He Who Must Not Be Named.") -> "Yes"
	public String isCareful(String statement) {
		if (statement.contains("Voldemort")) {
			return "No";
		} else {
			return "Yes";
		}
	}

	//10. roundOnBothEnds("Ohio") -> true
	//    roundOnBothEnds("Oklahoma") -> false
	public boolean roundOnBothEnds(String name) {
		String lowerName = name.toLowerCase();
		boolean startsWithO = lowerName.startsWith("o");
		boolean endsWithO = lowerName.endsWith("o");
		return startsWithO && endsWithO;
	}

	//11. sayItLouder("Look out!") -> "LOOK OUT!"
	public String sayItLouder(String phrase) {
		return phrase.toUpperCase();
	}

	//12. princeToFrog("The prince sat by the pond.") -> "The frog sat by the pond. "
	public String princeToFrog(String story) {
		return story.replace("prince", "frog");
	}

	//13. isDarthVader("Anakin", "Skywalker") -> true
	public boolean isDarthVader(String firstName, String lastName) {
		String fullName = firstName + " " + lastName;
		return fullName.equals("Anakin Skywalker");
	}


}
