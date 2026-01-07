package vn.devpro.lession2.trioperator;

public class MaxProblem {
	public static void main(String[] args) {
		int a = 6, b = 7, c = 9;
		int max = a;
		max = (max < b) ? b : max;
		max = (max < c) ? c : max;
		
		System.out.println("max = " + max);
		
	}
}
