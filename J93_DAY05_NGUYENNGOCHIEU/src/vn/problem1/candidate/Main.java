package vn.problem1.candidate;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Candidate[] candidates = null; 

        do {
            System.out.println("\n\t\tCHUONG TRINH QUAN LY THI SINH");
            System.out.println("1. Nhap danh sach thi sinh");
            System.out.println("2. Hien thi danh sach thi sinh");
            System.out.println("3. Sap xep theo tong diem");
            System.out.println("4. Hien thi 5 thi sinh co diem cao nhat");
            System.out.println("0. Thoat");
            System.out.print("Lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    candidates = Problem_1.init();
                    break;
                case 2:
                    if (candidates != null) {
                        Problem_1.display(candidates);
                    } else {
                        System.out.println("Chua co du lieu, vui long nhap truoc!");
                    }
                    break;
                case 3:
                    if (candidates != null) {
                        Problem_1.sort(candidates);
                        System.out.println("Da sap xep xong!");
                    } else {
                        System.out.println("Chua co du lieu, vui long nhap truoc!");
                    }
                    break;
                case 4:
                    if (candidates != null) {
                        Problem_1.highestScores(candidates);
                    } else {
                        System.out.println("Chua co du lieu, vui long nhap truoc!");
                    }
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
            }
        } while (true);
    }
}
