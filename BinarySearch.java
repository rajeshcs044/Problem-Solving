public class BinarySearch {
	public static void main(String[] args) {

		int[] input = { 1, 3, 5, 6, 9, 10, 11, 12, 13, 15 };
		int find = 9;
		System.out.println("The index of the " + find + " is: "
				+ binarySearch(input, find, 0, input.length - 1));
	}

	public static int binarySearch(int[] input, int find, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (input[mid] == find) {
			return mid;
		} else if (input[mid] < find) {
			return binarySearch(input, find, mid + 1, end);
		} else {
			return binarySearch(input, find, start, mid - 1);
		}
	}
}

