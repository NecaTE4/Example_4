import java.util.Scanner;

public class HW4_Q3_150120053 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a Letter: ");
		String let = input.next();
		char letter = let.charAt(0);
		if (letter < 123 && letter > 96 && let.length() == 1) {
			letter = (char) (letter - 32);
			printDiamond(constructDiamond(letter));
		} else if (let.length() > 1 || let.length() < 1 ) {
			System.out.println("Invalid Input !");
		} else if (!((letter>64 && letter<91)||(letter>96 && letter<123))) {
			System.out.println("Invalid Input !");
		} else
			printDiamond(constructDiamond(letter));

	}

	public static char[][] constructDiamond(char letter) {
		char[][] constructDiamond = new char[((char) (letter) - 64) * 2 - 1][((char) (letter) - 64) * 2 - 1];

		for (int i = 0; i < constructDiamond.length; i++) {
			for (int j = 0; j < constructDiamond.length; j++) {
				if ((j == (constructDiamond.length) / 2 - i) || (j == (constructDiamond.length) / 2 + i)) {
					constructDiamond[i][j] = (char) (65 + i);
				} else if (i > constructDiamond.length / 2
						&& (j == ((constructDiamond.length) / 2) - (((constructDiamond.length) - 1) - i)
								|| j == ((constructDiamond.length) / 2) + (((constructDiamond.length) - 1) - i))) {
					constructDiamond[i][j] = (char) (65 + (constructDiamond.length - i - 1));
				} else
					constructDiamond[i][j] = (char) (46);

			}
		}
		return constructDiamond;
	}

	public static void printDiamond(char[][] constructDiamond) {
		for (int i = 0; i < constructDiamond.length; i++) {
			for (int j = 0; j < constructDiamond.length; j++) {
				System.out.print(constructDiamond[i][j]);
			}
			System.out.println();
		}
	}
}
