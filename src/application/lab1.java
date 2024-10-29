package application;

import java.lang.reflect.Array;
import java.util.Arrays;

public class lab1 {

	public static void printn(int n) {

		if (n >= 0) {
			printn(n - 1);
			System.out.print(n + "\t");

		} else {
			return;
		}

	}

	public String reverse(String s) {
		if (s == null || s.lastIndexOf(" ") == -1) {
			return s;
		}
		int i = s.lastIndexOf(" ");

		return s.substring(1 + i) + " " + reverse(s.substring(0, i));

	}

	public static double Power(int m, int i) {

		return Power(m, i, 1);
	}

	private static double Power(int m, int i, int res) {

		if (i == 0) {
			return res;
		}
		return Power(m, --i, res * m);

	}

	public static int countCher(String s, char c) {
		return countCher(s, c, 0, 0);
	}

	private static int countCher(String s, char c, int i, int res) {
		if (i >= s.length())
			return res;
		if (s.charAt(i) == c)
			return countCher(s, c, ++i, ++res);
		return countCher(s, c, ++i, res);
	}

	public static int SumDigits(int n) {
		if (n < 10) {
			return n;
		} else {
			return SumDigits(n % 10 + SumDigits(n / 10));
		}
	}

	public static int binarySearch(int[] array, int kay) {
		Arrays.sort(array);

		return binarySearch(array, kay, 0, array.length);

	}

	private static int binarySearch(int[] array, int Kay, int l, int h) {
		try {

			if (l <= h) {
				int mid = l + (h - l) / 2;

				if (array[mid] == Kay) {
					return mid;
				} else if (array[mid] < Kay) {

					return binarySearch(array, Kay, mid + 1, h);
				} else {

					return binarySearch(array, Kay, l, mid - 1);
				}
			}
		} catch (Exception e) {
			return -1;
		}

		return -1;
	}

}