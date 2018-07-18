import java.util.Arrays;

public class Palindrome {

	public static void main(String[] args) {

		int a[] = new int[] { 7, 1, 3, 3, 2, 2 };

		printPalindrome(a);
	}

	private static void printPalindrome(int[] a) {

		boolean leftsmaller = false;

		int lenght = a.length;

		int mid = lenght / 2;

		int i = mid - 1;
		int j = (lenght % 2 == 0) ? mid : mid + 1;

		while (a[i] == a[j]) {
			i--;
			j++;
		}

		if (i < 0 || a[i] < a[j]) {
			leftsmaller = true;
		}

		while (i >= 0) {
			a[j] = a[i];
			i--;
			j++;
		}

		if (leftsmaller) {
			int c = 1;

			if (lenght % 2 != 0) {
				a[mid] += 1;
				c = a[mid] / 10;
				a[mid] %= 10;
			}

			i = mid - 1;
			j = (lenght % 2 == 0) ? mid : mid + 1;

			while (i >= 0 && c > 0) {
				a[i] += c;
				c = a[mid] / 10;
				a[mid] %= 10;
				a[j] = a[i];
				i--;
				j++;
			}

		}

		System.out.println(Arrays.toString(a));
	}

}
