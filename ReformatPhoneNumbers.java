
public class ReformatPhoneNumbers {

	public static void main(String[] args) throws Exception {
		String[] input = { "123-321-4567", "1234567890", "111-333-6666" };
		Reformat(input);
		for (String string : input) {
			System.out.println(string);
		}

	}

	public static void Reformat(String[] phonenumbers) throws Exception {
		for (int i = 0; i < phonenumbers.length; i++) {
			String str = phonenumbers[i];
			if (str.length() == 10) {
				phonenumbers[i] = str.substring(3, 6) + "-" + str.substring(0, 3) + "-" + str.substring(6);
			} else if (str.length() == 12) {
				phonenumbers[i] = str.substring(4, 7) + "-" + str.substring(0, 3) + "-" + str.substring(8);
			} else {
				throw new Exception("invalid format");
			}
		}
	}
}
