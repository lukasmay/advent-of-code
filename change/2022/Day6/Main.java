import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.CharSequence;
public class Main {
	public static void main(String[] args) {
		part1();
		part2();
	}
	//between 2733 and 2747
	public static void part2(){
		String current = "mrzpvdfblmhlzr";
		int i = 0;
		try {
			Scanner scanner = new Scanner(new File("input.txt"));
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				char[] input = line.toCharArray();
				for (char letter : input){
					i++;
					current = current + String.valueOf(letter);
					if (check(current)){
						current = current.substring(1, current.length());
					} else {
						System.out.println(i-1);
						break;
					}
				}
			}

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void part1(){
		char first = '1';
		char second = '1';
		char third = '1';
		int i = 0;
		try {
			Scanner scanner = new Scanner(new File("input.txt"));
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				char[] input = line.toCharArray();
				first = input[0];
				second = input[1];
				third = input[2];
				for (char letter : input){
					i++;
					if (letter == first || letter == second || letter == third || first == second || first == third || second == third){
						third = second;
						second = first;
						first = letter;
					} else {
						System.out.println(i);
						break;
					}
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static boolean check(CharSequence checkString) {
  		return checkString.length() != checkString.chars().distinct().count();
}
}