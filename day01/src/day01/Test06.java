package day01;

import java.util.Arrays;
import java.util.Collections;

public class Test06 {
	static int partition(Integer[] a, int low, int high) {
		// 기준 수보다 작은 숫자들을 왼쪽에 큰 숫자들을 오른쪽에 위치시키고,
		// 기준 수보다 큰 첫 번째 숫자를 기준수와 교환한다.
		// 기준 수의 인덱스를 반환한다.
		int cnt = low;
		for (int i = low; i < high; i++) {
			if (a[i] < a[high]) {
				int big = a[cnt];
				a[cnt] = a[i];
				a[i] = big;
				cnt++;
			}
		}
		int big = a[cnt];
		a[cnt] = a[high];
		a[high] = big;

		return cnt;
	}

	static void devide(Integer[] a, int low, int high) {
		// 원소가 1개 이하가 될 때까지 반복하여 반으로 나눈다.
		if (high - low <= 0)
			return;
		int s = partition(a, low, high);
		devide(a, low, s - 1);
		devide(a, s + 1, high);
	}

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
		devide(a, 0, n - 1);
		for (var i : a) {
			System.out.printf("%3d", i);
		}
		System.out.println();
	}
}