public class PriorityBasedProductCodes {
	public static void main(String[] args) {
		// 1 high, 2 medium, 3 for low
		String[] productCodes = { "1", "2", "3", "2", "1", "3", "3"/* ,"2","1","1","1","3","2" */ };
		OrderProducstByPriority(productCodes);
		for (String string : productCodes) {
			System.out.print(string);
		}
	}

	public static void OrderProducstByPriority(String[] productCodes) {
		int offset = 0;
		offset = bringPriorityToFirst(productCodes, 1, offset);
		offset = bringPriorityToFirst(productCodes, 2, offset);
	}

	public static int bringPriorityToFirst(String[] productCodes, int priority, int offset) {
		int i = offset;
		int j = productCodes.length - 1;
		while (i < j) {
			i = getNextNonPriority(productCodes, priority, i);
			j = getPreviousPriority(productCodes, priority, j);
			if (i == -1 || i == productCodes.length || j == -1) {
				return getPreviousPriority(productCodes, priority, productCodes.length - 1) + 1;
			} else if (i < j) {
				String str = productCodes[i];
				productCodes[i] = productCodes[j];
				productCodes[j] = str;
			}
		}
		return i;
	}

	private static int getNextNonPriority(String[] productCodes, int priority, int start) {
		for (int i = start; i < productCodes.length; i++) {
			if (getPriority(productCodes[i]) != priority) {
				return i;
			}
		}
		return productCodes.length;
	}

	private static int getPreviousPriority(String[] productCodes, int priority, int end) {
		for (int i = end; i >= 0; i--) {
			if (getPriority(productCodes[i]) == priority) {
				return i;
			}
		}
		return -1;
	}

	private static int getPriority(String string) {
		return Integer.parseInt(string);
	}
}
