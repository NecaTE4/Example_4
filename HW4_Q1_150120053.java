//Name: Necati
//Surname: Koçak
//Student ID: 150120053

/*Write a program that calculates the invoice of each flat in an apartment building. Assume that 
there are N flats in a building and apartment heating is the central system.*/

import java.util.Scanner;

public class HW4_Q1_150120053 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//We ask the user for the number of flats. 
		//Then we get the volumes of the flats in the array from the user.
		int NumberOfFlats = input.nextInt();
		double[] flats = new double[NumberOfFlats];
		for (int i = 0; i < flats.length; i++) {
			flats[i] = input.nextDouble();
		}
		double totalbill = input.nextDouble();
		double[] bills = calculateTheInvoice(flats, totalbill);
		printBills(bills);
	}
	//we write the appropriate method
	public static double[] calculateTheInvoice(double[] flats, double totalbill) {
		//Summing up the volumes of the flats in the array
		double TotalFlats = 0;
		for (int i = 0; i < flats.length; i++) {
			TotalFlats += flats[i];
		}
		//We calculate the corresponding invoice per flat.
		double[] billPerFlat = new double[flats.length];
		for (int i = 0; i < flats.length; i++) {
			billPerFlat[i] = ((totalbill * 0.3) / flats.length) + ((totalbill * 0.7) * (flats[i] / TotalFlats));
		}
		return billPerFlat;
	}
//We write the method to print
	public static void printBills(double[] billPerFlat) {

		for (int i = 0; i < billPerFlat.length; i++) {
			System.out.println("Flat #" + (i + 1) + ": " + (int) (billPerFlat[i] * 100) / 100.0);
		}

	}

}