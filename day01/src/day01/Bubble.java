package day01;

import java.util.Arrays;
import java.util.Collections;

public class Bubble {
	public static void main(String[] args) {
		var n = 10;
		var a = new Integer[n];
		for (var i = 0; i < n; i++) {
			a[i] = i;
		}
		Collections.shuffle(Arrays.asList(a));
		for (var i : a) { 
			System.out.printf("%3d", i);
		}
		System.out.println();
		for (int j = n - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				if (a[i] > a[i + 1]) {
					int chan = a[i];
					a[i] = a[i + 1];
					a[i + 1] = chan;
				}
			}
			for (var i : a) {
				System.out.printf("%3d", i);
			}
			System.out.println();
		}
		for (var i : a) {
			System.out.printf("%3d", i);
		}
		System.out.println();
	}
}

