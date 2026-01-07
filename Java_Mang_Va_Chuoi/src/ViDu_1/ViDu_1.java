package ViDu_1;

import java.util.Scanner;

public class ViDu_1 {
	static Scanner sc = new Scanner(System.in);
	public static int[] init() {
		int[] a = {30, -23, 67, 98, 309, 213, -456, 67, 341, 67, 230};
		return a;
	}
	public static void display(int[] a) {
		for(int index = 0; index < a.length ; index ++) {
			System.out.print(a[index] + " ");
		}
		System.out.println();
	}
	public static int getInput() {
		int x;
		System.out.print("\tNhap " + "x : ");
		x = Integer.parseInt(sc.nextLine());
		return x;	
	}
	//Ham tim vi tri dau tien cua x
	public static int findFirst(int x, int[] a) {
		for(int i=0 ; i<a.length ; i++) {
			if(x == a[i]) return i;
		}
		return -1;
	}
	// dem so lan suat hien
	public static int countX(int x, int[] a) {
		int ct = 0;
		for(int i=0 ; i<a.length ; i++) {
			if(a[i] == x) {
				ct ++;
				
			}
		}
		return ct;
	}
	public static int demX(int x, int[] a, int[] b) {
		int ct = 0;
		for(int i=0 ; i<a.length ; i++) {
			if(a[i] == x) {
				b[ct] = i;
				ct ++;
			}
		}
		return ct;
	}
	//Xac dinh vi tri xuat hien
	public static int[] getPositionX(int x, int[] a) {
		int n=0;
		int[] pos = new int[0];
		for(int i=0 ; i<a.length ; i++) {
			if(a[i] == x) {
				int[] temp = new int[n + 1];
				if(n > 0) {
					for(int j=0 ; j<n ; j++) {
						temp[j] = pos[j];
					}
				}
				temp[n] = i;
				n++;
				pos = temp;
			}
		}
		return n>0 ? pos : null;
	}
	public static void main(String[] args) {
		int[] a = init();
		display(a);
		int x = getInput();
		if(findFirst(x, a) == -1) {
			System.out.println(x + "Khong xuat hien trong mang");
		}
		else {
			System.out.println("So lan xuat hien la: " + countX(x, a));
			
			int[] pos = getPositionX(x, a);
			System.out.println("cac vi tri ");
			display(pos);
		}
	}
}
