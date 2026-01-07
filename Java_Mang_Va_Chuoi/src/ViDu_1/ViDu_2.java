package ViDu_1;

import java.util.Scanner;

public class ViDu_2 {

	static Scanner sc = new Scanner(System.in);

	public static int[] init() {
		int[] a = new int[32];
		for (int i = 0; i < a.length; i++)
			a[i] = 0;
		return a;
	}

	public static void display(int[] a) {
		for (int index = 0; index < a.length; index++) {
			System.out.print(a[index] + "");
		}
		System.out.println();
	}

	public static int getInput() {
		int x;
		System.out.print("\tNhap " + "x : ");
		x = Integer.parseInt(sc.nextLine());
		return x;
	}
	
	public static int[] changeToBinary(int n) {
		int m = n;
		int[] a = init();
		int j=a.length - 1;
		while(m > 0) {
			a[j] = m%2;
			j--;
			m /= 2;
		}
		return a;
	}
	public static void main(String[] args) {
		int n = getInput();
		int change[] = changeToBinary(n);
		display(change);
	}
}
