import java.util.ArrayList;
public class GFG {
	private static ArrayList<ArrayList<String>> permutations = new ArrayList<>();
	private static ArrayList<String> holder = new ArrayList<>();

	// Function to print all the permutations of str
	static void printPermutn(String str, String ans) {
		// If string is empty
		if (str.length() == 0) {
			System.out.print(ans + " ");
			holder.add(ans);
			return;
		}

		for (int i = 0; i < str.length(); i++) {

			// ith character of str
			char ch = str.charAt(i);

			// Rest of the string after excluding
			// the ith character
			String ros = str.substring(0, i) +
						str.substring(i + 1);

			// Recursive call
			printPermutn(ros, ans + ch);
		}
	}
	public void addPermutation(){
		permutations.add(holder);
	}

	public ArrayList<String> getHolder(){
		return this.holder;
	}
}