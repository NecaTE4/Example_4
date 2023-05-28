//Name: Necati
//Surname: Koçak
//Student ID: 150120053

/*Write a program that will determine whether or not it is valid per the Luhn formula. 
 The Luhn algorithm is a simple checksum formula used to validate a variety of identification numbers
*/

import java.util.Scanner; //Scanner is in the java.util package

public class HW4_Q2_150120053 {
	public static void main(String[] args) {
		// We create a Scanner object
		Scanner input = new Scanner(System.in);
		// We get the number from the user.
		String identificationNumbers = input.nextLine();
		int x = 1;
		// We check if there are any invalid characters in the number.
		for (int i = 0; i < identificationNumbers.length(); i++) {
			if ((!(identificationNumbers.charAt(i) == 32 || (int) (identificationNumbers.charAt(i)) >= 48
					&& (int) (identificationNumbers.charAt(i)) <= 57))) {
				x = 0;
				break;
			}

		}
		// If there is an invalid character, it will give an "invalid character"
		// warning,
		// otherwise it will enter the following processes
		if (x == 0) {
			System.out.println("Invalid Input !");
		} else {

			if (validateNumber(identificationNumbers) == true)
				System.out.println("Number is Valid");

			else
				System.out.println("Number is Invalid");

		}

	}

	// We write the method in which we do the actual operations
	public static boolean validateNumber(String identificationNumbers) {
		// If there are spaces, we define the string that will delete the spaces in
		// between.
		String result = "";
		// We print without spaces
		for (int i = 0; i < identificationNumbers.length(); i++) {
			if (identificationNumbers.charAt(i) != 32) {
				result = result + identificationNumbers.charAt(i);
			}
		}
		// We define DNumber and LNumber
		String DNumber = "";
		String LNumber = "";

		// If the non-blank state is odd, we put it into this process. We print the
		// dnumber
		// and write "_" to the double digits from the right.
		if (result.length() % 2 == 1) {
			for (int j = 0; j < result.length(); j++) {

				if (j % 2 == 1) {
					DNumber = DNumber + result.charAt(j);

				} else {
					DNumber = DNumber + "_";
				}
			}
			// We print the LNumber state
			for (int i = 0; i < result.length(); i++) {
				if (i % 2 == 1) {
					if ((result.charAt(i) * 2 - 96) > 9) {
						LNumber = LNumber + ((result.charAt(i) * 2 - 96) - 9);
					} else
						LNumber = LNumber + (result.charAt(i) * 2 - 96);
				} else
					LNumber = LNumber + result.charAt(i);
			}

		}
		// If the non-blank state is even, we put it into this process. We print the
		// dnumber
		// and write "_" to the double digits from the right.
		if (result.length() % 2 == 0) {
			for (int j = 0; j < result.length(); j++) {

				if (j % 2 == 0) {
					DNumber = DNumber + result.charAt(j);

				} else {
					DNumber = DNumber + "_";
				}
			}
			// We print the LNumber state
			for (int i = 0; i < result.length(); i++) {
				if (i % 2 == 0) {
					if ((result.charAt(i) * 2 - 96) > 9) {
						LNumber = LNumber + ((result.charAt(i) * 2 - 96) - 9);
					} else
						LNumber = LNumber + (result.charAt(i) * 2 - 96);
				} else
					LNumber = LNumber + result.charAt(i);
			}
		}
		// Display DNumber and LNumber
		System.out.println("DNumber:" + DNumber);
		System.out.println("LNumber:" + LNumber);

		int sumdigits = 0;

		for (int i = 0; i < LNumber.length(); i++) {
			sumdigits = sumdigits + (LNumber.charAt(i) - 48);
		}
		// If it is divisible by 10, we return true, otherwise false.
		if (sumdigits % 10 == 0) {
			return true;
		} else
			return false;

	}

}
