package com.sachi;

import java.util.Arrays;
import java.util.Scanner;

public class Flentas {

	static long minimumCost(long costarray[], int n) {

		// sort the array using collection method
		Arrays.sort(costarray);
// calculate the total cost
		long totalCost = 0;

		for (int i = n - 1; i > 1; i -= 2) {
			if (i == 2) {
				totalCost += costarray[2] + costarray[0];
			} else {

				long price_first = costarray[i] + costarray[0] + 2 * costarray[1];
				long price_second = costarray[i] + costarray[i - 1] + 2 * costarray[0];
				totalCost += Math.min(price_first, price_second);
			}
		}

		if (n == 1) {
			totalCost += costarray[0];
		} else {
			totalCost += costarray[1];
		}

		return totalCost;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of person cost");
		int noofpeople = sc.nextInt();
		long costarray[] = new long[noofpeople];
		for (int i = 0; i < noofpeople; i++) {
			costarray[i] = sc.nextInt();
		}

		System.out.println(minimumCost(costarray, noofpeople));
	}
}
