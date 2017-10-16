public class RemoveDuplicates {

	public static void main(String[] args) {
		String str = "AjitAjitPrakash";
		System.out.println("After removing duplicates: " + removeDuplicates(str));
	}

	private static String removeDuplicates(String str) {
		int[] value = new int[256];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			int temp = str.charAt(i);
			if (value[temp] == 0) {
				value[temp] = 1;
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}
}
