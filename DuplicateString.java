public class DuplicateString {
	public static void main(String[] args) {
		String str = "Rajesh";
		System.out.println("The String '" + str + "' has duplicate characters: " + hasDuplicate(str));
		str = "Prakash";
		System.out.println("The String '" + str + "' has duplicate characters: " + hasDuplicate(str));
	}

	private static boolean hasDuplicate(String str) {
		int[] temp = new int[26];
		char[] charArray = str.toLowerCase().toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			int a = charArray[i] - 'a';
			if (temp[a] == 1) {
				return true;
			} else {
				temp[a] = 1;
			}
		}
		return false;
	}
}

