package vn.problem2.vocabulary;

import java.util.Scanner;

import vn.problem1.candidate.Candidate;

public class Problem_2 {
	static Scanner sc = new Scanner(System.in);
	 public static String[] init() {
	        System.out.print("Nhap so luong n: ");
	        int n = sc.nextInt();
	        sc.nextLine(); 

	        String[] vocab = new String[n];
	        System.out.println("Nhap danh sach tu vung");
	        for (int i = 0; i < n; i++) {
	            System.out.print("Nhap tu vung thu " + (i + 1) + " : ");
	            vocab[i] = sc.nextLine().trim();
	        }
	        return vocab;
	    }
	public static boolean isOnList(String str, String[] vocab) {
		for(int i=0 ; i<vocab.length ; i++) {
			if( str.equalsIgnoreCase(vocab[i])){
				return true;
			}
		}
		return false;
	}
	 public static void display(String[] vocab) {
	        System.out.println("\nDanh sach tu tieng anh:");
	        for(int i=0 ; i<vocab.length ; i++) {
	        	System.out.printf("%-15s",vocab[i]);
	        	 if ((i + 1) % 4 == 0) {
	                 System.out.println();
	             }
	        }
	 }
	 public static void sort(String[] vocab) {
		 String tmp;
		 for(int i=0 ; i<vocab.length - 1; i++) {
			 for(int j=i+1 ; j<vocab.length ; j++) {
				 if(vocab[i].compareTo(vocab[j]) > 0) {
					 tmp = vocab[i];
					 vocab[i] = vocab[j];
					 vocab[j] = tmp;
				 }
			 }
		 }
		 System.out.println("Da sap xep");
	 }
	 
}
