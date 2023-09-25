package day01;

import java.util.Arrays;
import java.util.Collections;

public class Test04 {
	static void merge(Integer[] a, int low, int mid, int high) {
		// 나눠진 두 리스트를 정렬하며 합친다.
		// 새 배열 생성
		int[] arr = new int[high + 1];
		// a 범위는 = s ~ mid - 1
		int s = low;
		// m 범위는 =  mid 
		int m = mid;
		for (int i = 0; i < high - low + 1; i++) {
			if (s >= mid) arr[low + i] = a[m++];
			else if (m > high) arr[low + i] = a[s++];
			else if (a[s] > a[m]) {
				arr[low + i] = a[m++];
			} else {
				arr[low + i] = a[s++];
			}
		}
		for (int i = low; i < high + 1; i++) {
			a[i] = arr[i];
		}
	}

	static void devide(Integer[] a, int low, int high) {
		// 원소가 1개 이하가 될 때까지 반복하여 반으로 나눈다.
		if ((high + low) / 2 == high) return;
		System.out.println(low + " " + high);
		var mid = (high + low) / 2;
		devide(a, low, mid);
		devide(a, mid + 1, high);
		merge(a, low, mid + 1, high);
	}

	public static void main(String[] args) {
		var n = 129;
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