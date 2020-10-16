package com.techelevator;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {
		//Initial demo of FlowerShopOrder
		FlowerShopOrder exampleOrder = new FlowerShopOrder("Example", 0);
		System.out.println(exampleOrder);
		exampleOrder = new FlowerShopOrder("Example", 1);
		System.out.println(exampleOrder);
		exampleOrder = new FlowerShopOrder("Example", 2);
		System.out.println(exampleOrder);

		System.out.println("----------------------------");

		//Read from CSV and add up subtotals.
		List<FlowerShopOrder> orders = new ArrayList<>();
		Path file = Paths.get("FlowerInput.csv");
		try (Scanner fileScanner = new Scanner(file)) {
			while (fileScanner.hasNextLine()) {
				String[] lineParts = fileScanner.nextLine().split(",");
				String bouquetType = lineParts[0];
				int numberOfRoses = Integer.parseInt(lineParts[1]);
				orders.add(new FlowerShopOrder(bouquetType, numberOfRoses));
			}
		} catch (IOException e) {
			System.out.println("Couldn't read input file.");
		}
		BigDecimal total = new BigDecimal("0.00");
		for (FlowerShopOrder order : orders) {
			System.out.println(order);
			total = total.add(order.getSubtotal());
		}
		System.out.println("Total of subtotals: $" + total);
	}

}
