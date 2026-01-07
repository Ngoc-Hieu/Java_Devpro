package vn.problem2.vocabulary;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] vocab = null;

        do {
            System.out.println("\n\t\tCHUONG TRINH QUAN LY TU VUNG");
            System.out.println("1. Nhap danh sach tu vung");
            System.out.println("2. Hien thi danh sach tu vung");
            System.out.println("3. Sap xep tu vung theo alphabet");
            System.out.println("4. Kiem tra tu vung co trong danh sach");
            System.out.println("0. Thoat");
            System.out.print("Lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    vocab = Problem_2.init();
                    break;
                case 2:
                    if (vocab != null) {
                        Problem_2.display(vocab);
                    } else {
                        System.out.println("Chua co du lieu, vui long nhap truoc!");
                    }
                    break;
                case 3:
                    if (vocab != null) {
                        Problem_2.sort(vocab);
                    } else {
                        System.out.println("Chua co du lieu, vui long nhap truoc!");
                    }
                    break;
                case 4:
                    if (vocab != null) {
                        System.out.print("Nhap tu can kiem tra: ");
                        String word = sc.nextLine().trim();
                        if (Problem_2.isOnList(word, vocab)) {
                            System.out.println("Tu \"" + word + "\" co trong danh sach!");
                        } else {
                            System.out.println("Tu \"" + word + "\" khong co trong danh sach!");
                        }
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
