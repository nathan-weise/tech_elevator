package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		boolean finished = false;
		while (!finished) {

			System.out.print("Please enter the Fibonacci number: ");
			String value = input.nextLine();
			int fibonacciNumberInput = Integer.parseInt(value);

			int number1 = 0;
			int number2 = 1;
			int sum = 0;

			if (fibonacciNumberInput == number1) {
				System.out.println(number1);
			}
			else if (fibonacciNumberInput == number2) {
				System.out.println(number1 + ", " + number2);
			} else {

				System.out.print(number1);

				for (int i = 0; fibonacciNumberInput >= sum; ++i) {

					sum = number1 + number2;
					System.out.print(", " + number2);
					number1 = number2;
					number2 = sum;

					//if (fibonacciNumberInput < sum) {
						//System.out.println("");
						//break;
					//}
				}



			}
			System.out.println();
			System.out.print("Are you finished (yes/no)? ");
			String answer = input.nextLine();
			finished = answer.equals("yes");
		}
	}
}


