package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		while (true) {
			Scanner input = new Scanner(System.in);

			System.out.print("Enter Temperature to Convert: ");
			String tempValue = input.nextLine();
			double temperatureInput = Double.parseDouble(tempValue);

			System.out.print("Enter (C)elsius or (F)ahrenheit?: ");
			String celsiusOrFahrenheit = input.nextLine();


			if (celsiusOrFahrenheit.equals("C")) {
				System.out.println("Celsius: = " + temperatureInput + "  |  Fahrenheit: " + (temperatureInput * 1.8 + 32));
			}
			if (celsiusOrFahrenheit.equals("F")) {
				System.out.println("Celsius: = " + ((temperatureInput - 32) / 1.8) + "  |  Fahrenheit: " + temperatureInput);
			}


		}
	}

}
