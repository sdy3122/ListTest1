package day01;

import java.util.Arrays;
import java.util.Collections;

public class Test02 {
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
		for (int j = 1; j < n; j++) {
			int chan = a[j];
			int s = j;
			while (s > 0 && a[s - 1] > chan) {
				a[s] = a[s - 1];
				s--;
			}
			a[s] = chan;
		}
		for (var i : a) {
			System.out.printf("%3d", i);
		}
		System.out.println();
	}
}
