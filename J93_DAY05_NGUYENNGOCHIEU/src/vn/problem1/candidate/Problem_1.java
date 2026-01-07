package vn.problem1.candidate;

import java.util.Scanner;

public class Problem_1 {
    static Scanner sc = new Scanner(System.in);

    public static float getScore(String message) {
        float x;
        System.out.print("\tNhập " + message + " (0 - 10): ");
        do {
            x = sc.nextFloat();
            if (x < 0 || x > 10) {
                System.out.println("Điểm không hợp lệ, nhập lại!");
            }
        } while (x < 0 || x > 10);
        return x;
    }

    public static Candidate[] init() {
    	System.out.print("Nhập số lượng thí sinh n: "); 
    	int n = sc.nextInt(); 
    	Candidate[] c = new Candidate[n]; 
    	for (int i = 0; i < n; i++) { 
    		System.out.println("Thí sinh thứ " + (i + 1) + ":"); 
    		c[i] = new Candidate(); 
    		c[i].math = getScore("Điểm Toán"); 
    		c[i].vietnamese = getScore("Điểm Văn"); 
    		c[i].english = getScore("Điểm Anh"); 
    		} 
    	return c;
    }

    public static void display(Candidate[] c) {
        System.out.println("\nDanh sách thí sinh:");
        for (int i = 0; i < c.length; i++) {
            System.out.println("Thí sinh " + (i + 1) +
                    " - Toán: " + c[i].math +
                    ", Văn: " + c[i].vietnamese +
                    ", Anh: " + c[i].english);
        }
    }
    public static float[] totalScore(Candidate[] c) {
    	float[] result = new float[c.length];
    	for(int i=0 ; i<c.length ; i++) {
    		result[i] = c[i].math + c[i].vietnamese + c[i].english * 2;
    	}
    	return result;
    }
    public static void sort(Candidate[] c) {
        float[] score = totalScore(c);
        for (int i = 0; i < c.length - 1; i++) {
            for (int j = i + 1; j < c.length; j++) {
                if (score[i] > score[j]) {
                    Candidate tmpC = c[i];
                    c[i] = c[j];
                    c[j] = tmpC;

          
                    float tmpS = score[i];
                    score[i] = score[j];
                    score[j] = tmpS;
                }
            }
        }
    }
    public static void highestScores(Candidate[] c) {
    	System.out.println("Tthi sinh co diem cao nhat");
    	sort(c);
    	int idx = c.length - 1;
    	while(idx >= c.length - 5 && idx >=0) {
    		System.out.println("Thí sinh " + (idx + 1) +
                    " - Toán: " + c[idx].math +
                    ", Văn: " + c[idx].vietnamese +
                    ", Anh: " + c[idx].english);
    		idx--;
    	}
    }

}
