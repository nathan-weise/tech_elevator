package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		boolean finished = false;
		while (!finished) {

			Scanner input = new Scanner(System.in);

			System.out.print("Please enter the length: ");
			String valueLength = input.nextLine();
			int length = Integer.parseInt(valueLength);

			System.out.print("Is the measurement in (m)eter, or (f)eet?: ");
			String valueUnit = input.nextLine();

			double feetToMeters = length * 0.3048;
			double metersToFeet = length * 3.2808399;

			if (valueUnit.equals("f")) {
				System.out.println("Meters = " + feetToMeters + "   |   " + "Feet = " + length);
			}
			if (valueUnit.equals("m")) {
				System.out.println("Meters = " + length + "   |   " + "Feet = " + metersToFeet);
			}

			System.out.print("Are you finished (yes/no)? ");
			String answer = input.nextLine();
			finished = answer.equals("yes");


		}

	}
}