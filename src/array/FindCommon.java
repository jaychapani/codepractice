package array;

public class FindCommon {

	public static void main(String[] args) {

		int a[] = new int[] { 13, 27, 35, 40, 49, 55, 59 };
		int b[] = new int[] { 17, 35, 39, 40, 55, 58, 60 };
		
		System.out.println((int)"a".charAt(0));

		System.out.println(isUniqueChar("abac"));

		int bstart = 0;

		for (int i = 0; i < a.length; i++) {
			bstart = findInB(bstart, a[i], b);
			if (bstart > 0) {
				System.out.println(b[bstart]);
				bstart++;
			} else {
				bstart = -bstart;
			}

		}
	}
	

	private static boolean isUniqueChar(String str) {
		int checker= 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}

	private static int findInB(int start, int a, int[] b) {
		int x = Integer.MIN_VALUE;
		for (int i = start; i < b.length;) {
			if (b[i] == a) {
				x = i;
				break;
			} else if (b[i] > a) {
				x = -i;
				break;
			} else {
				i++;
			}
		}
		return x;
	}

}
