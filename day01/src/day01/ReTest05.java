package day01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ReTest05 {
	static int partition(Integer[] a, int low, int high) {
		// 기준 수보다 작은 숫자들을 왼쪽에 큰 숫자들을 오른쪽에 위치시키고,
		// 기준 수보다 큰 첫 번째 숫자를 기준수와 교환한다.
		// 기준 수의 인덱스를 반환한다.
		int cnt = low;
		for (int i = low; i < high; i++) {
			if (a[i] >= a[high]) continue;
			if (i != cnt) {
				int big = a[cnt];
				a[cnt] = a[i];
				a[i] = big;
			}
			cnt++;
		}
		int big = a[cnt];
		a[cnt] = a[high];
		a[high] = big;
		return cnt;
	}

	static int search(Integer[] a, int low, int high, int k) {
		// 인덱스 k의 수를 찾아 반환한다.
		int p = partition(a, low, high);
		if (p > k) search(a, low, p - 1, k);
		else if (p < k) search(a, p + 1, high, k);
		return a[k];
	}

	public static void main(String[] args) {
		var n = 7;
		var a = new Integer[n];
		for (var i = 0; i < n; i++) {
			a[i] = new Random().nextInt(30);
		}
		Collections.shuffle(Arrays.asList(a));
		for (var i : a) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		System.out.println(search(a, 0, n - 1, n-1));
		for (var i : a) {
			System.out.printf("%3d", i);
		}
	}
}