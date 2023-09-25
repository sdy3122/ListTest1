package day01;

import java.util.Arrays;
import java.util.Collections;

public class Test03 {
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
			int maxIn = 0;
			for (int i = 0; i <= j; i++) {
				if (a[i] > a[maxIn]) {
					maxIn = i;
				}
			}
			int chan = a[j];
			a[j] = a[maxIn];
			a[maxIn] = chan;
		}
		for (var i : a) {
			System.out.printf("%3d", i);
		}
		System.out.println();
	}
}
