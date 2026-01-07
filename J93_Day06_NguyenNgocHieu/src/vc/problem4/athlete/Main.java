package vc.problem4.athlete;

import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static Athlete[] init() {
		String[] names = { "Tran Viet Hung", "Quach Dong Tai", "Duong Huyen Nhu", "Chu Phuong Dung",
				"Nguyen Chien Thang", "Duong Quoc Truong", "Tran Quang Khai", "Phan Thu Phuong", "Dao Hung Manh",
				"Nguyen Ngoc Hieu", "Ngo Viet Tiep", "Nguyen Minh Duc" };
		Random rand = new Random();
		Athlete[] list = new Athlete[names.length];
		for (int i = 0; i < names.length; i++) {
			list[i] = new Athlete();
			list[i].name = names[i];
			for (int j = 0; j < 3; j++) {
				list[i].achieve[j] = rand.nextInt(50) + 50;
			}
		}
		return list;
	}

	public static void display(Athlete[] list) {
		System.out.printf("%-20s%16s%16s%16s%16s\n", "Ten VDV", "Thanh tich 1", "Thanh tich 2", "Thanh tich 3",
				"Tong TT");

		for (int i = 0; i < list.length; i++) {
			int total = list[i].achieve[0] + list[i].achieve[1] + list[i].achieve[2];
			;

			System.out.printf("%-20s", list[i].name);
			for (int j = 0; j < 3; j++) {
				System.out.printf("%16d", list[i].achieve[j]);
			}
			System.out.printf("%16d", total);
			System.out.println();
		}
	}

	public static void displayTopAthlete(Athlete[] list) {
		if (list.length == 0) {
			System.out.println("Danh sach rong");
			return;
		}

		Athlete topAthlete = list[0];
		int maxTotal = topAthlete.achieve[0] + topAthlete.achieve[1] + topAthlete.achieve[2];

		for (int i = 0; i < list.length; i++) {
			int currentTotal = list[i].achieve[0] + list[i].achieve[1] + list[i].achieve[2];
			if (currentTotal > maxTotal) {
				topAthlete = list[i];
				maxTotal = currentTotal;
			}
		}

		System.out.println("VDV co tong thanh tich cao nhat:");
		System.out.printf("%-20s%16s%16s%16s%16s\n", "Ten VDV", "Thanh tich 1", "Thanh tich 2", "Thanh tich 3",
				"Tong TT");

		System.out.printf("%-20s", topAthlete.name);
		for (int j = 0; j < 3; j++) {
			System.out.printf("%16d", topAthlete.achieve[j]);
		}
		System.out.printf("%16d", maxTotal);
		System.out.println();

	}

	public static void displayTop3(Athlete[] list) {
		Athlete[] sortList = list.clone();

		for (int i = 0; i < sortList.length - 1; i++) {
			for (int j = i + 1; j < sortList.length; j++) {
				int totalI = sortList[i].achieve[0] + sortList[i].achieve[1] + sortList[i].achieve[2];
				int totalJ = sortList[j].achieve[0] + sortList[j].achieve[1] + sortList[j].achieve[2];

				if (totalI < totalJ) {
					Athlete tmp = sortList[i];
					sortList[i] = sortList[j];
					sortList[j] = tmp;
				}
			}
		}

		System.out.println("\nTop 3 VDV co tong thanh tich cao nhat:");
		System.out.printf("%-20s%16s%16s%16s%16s\n", "Ten VDV", "Thanh tich 1", "Thanh tich 2", "Thanh tich 3",
				"Tong TT");

		for (int i = 0; i < 3 && i < sortList.length; i++) {
			int total = sortList[i].achieve[0] + sortList[i].achieve[1] + sortList[i].achieve[2];

			System.out.printf("%-20s", sortList[i].name);
			for (int j = 0; j < 3; j++) {
				System.out.printf("%16d", sortList[i].achieve[j]);
			}
			System.out.printf("%16d", total);
			System.out.println();
		}

	}

	public static String getName(String fullName) {
		int index = fullName.trim().lastIndexOf(" ");
		if (index == -1) {
			return fullName;
		} else {
			return fullName.trim().substring(index + 1);
		}
	}

	public static void sortByName(Athlete[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = i + 1; j < list.length; j++) {
				if (getName(list[i].name).compareToIgnoreCase(getName(list[j].name)) > 0) {
					Athlete tmp = list[i];
					list[i] = list[j];
					list[j] = tmp;
				}
			}
		}
	}

	public static Athlete[] filterByStartT(Athlete[] list) {

		int count = 0;
		for (int i = 0; i < list.length; i++) {
			char s = getName(list[i].name).charAt(0);
			if (s == 'T' || s == 't') {
				count++;
			}
		}

		Athlete[] startT = new Athlete[count];
		int idx = 0;
		for (int i = 0; i < list.length; i++) {
			char s = getName(list[i].name).charAt(0);
			if (s == 'T' || s == 't') {
				startT[idx] = list[i];
				idx++;
			}
		}
		return startT;
	}

	public static Athlete[] filterConstainAn(Athlete[] list) {
		int count = 0;
		for (Athlete x : list) {
			if (getName(x.name).toLowerCase().indexOf("an") >= 0) {
				count++;
			}
		}

		Athlete[] result = new Athlete[count];
		int index = 0;
		for (Athlete x : list) {
			if (getName(x.name).toLowerCase().indexOf("an") >= 0) {
				result[index] = x;
				index++;
			}
		}
		return result;
	}

	public static void sortByNameLength(Athlete[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = i + 1; j < list.length; j++) {
				if (getName(list[i].name).length() > getName(list[j].name).length()) {
					Athlete tmp = list[i];
					list[i] = list[j];
					list[j] = tmp;
				}
			}
		}
		
	}

	public static void display2Achieve(Athlete[] list) {
		if (list.length < 2) {
			System.out.println("Khong du VDV de xac dinh vi tri thu 2");
			return;
		}
		int maxTotal = list[0].achieve[0] + list[0].achieve[1] + list[0].achieve[2];
		for (Athlete x : list) {
			int total = x.achieve[0] + x.achieve[1] + x.achieve[2];
			if (total > maxTotal) {
				maxTotal = total;
			}
		}
		int secondTotal = list[0].achieve[0] + list[0].achieve[1] + list[0].achieve[2];
		for (Athlete x : list) {
			int total = x.achieve[0] + x.achieve[1] + x.achieve[2];
			if (total > secondTotal && total < maxTotal) {
				secondTotal = total;
			}
		}
		if (secondTotal == list[0].achieve[0] + list[0].achieve[1] + list[0].achieve[2]) {
			System.out.println("Khong co VDV nao o vi tri thu 2");
			return;
		}
		System.out.println("Cac VDV co thanh tich cao thu 2 (" + secondTotal + "):");
		System.out.printf("%-20s%16s%16s%16s%16s\n", "Ten VDV", "Thanh tich 1", "Thanh tich 2", "Thanh tich 3",
				"Tong TT");
		for (Athlete x : list) {
			int total = x.achieve[0] + x.achieve[1] + x.achieve[2];
			if (total == secondTotal) {
				System.out.printf("%-20s", x.name);
				for (int j = 0; j < 3; j++) {
					System.out.printf("%16d", x.achieve[j]);
				}
				System.out.printf("%16d", total);
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		Athlete[] list = init();
		int choice;

		do {
			System.out.println("\n===== MENU QUAN LY VDV CU TA =====");
			System.out.println("1. Hien thi danh sach VDV");
			System.out.println("2. Hien thi VDV co tong thanh tich cao nhat");
			System.out.println("3. Hien thi 3 VDV co thanh tich cao nhat");
			System.out.println("4. Sap xep danh sach theo ten");
			System.out.println("5. Hien thi VDV bat dau bang chu 'T'");
			System.out.println("6. Hien thi VDV co ten chua 'an'");
			System.out.println("7. Sap xep theo chieu dai ten");
			System.out.println("8. Hien thi VDV co thanh tich cao thu 2");
			System.out.println("0. Thoat chuong trinh");
			System.out.print("Chon chuc nang (0-8): ");
			choice = scanner.nextInt();
			scanner.nextLine(); 

			switch (choice) {
			case 1:
				System.out.println("\nDanh sach VDV:");
				display(list);
				break;
			case 2:
				displayTopAthlete(list);
				break;
			case 3:
				displayTop3(list);
				break;
			case 4:
				sortByName(list);
				System.out.println("Da sap xep");
				break;
			case 5:
				Athlete[] startWithT = filterByStartT(list);
				System.out.println("VDV bat dau bang chu 'T':");
				display(startWithT);
				break;
			case 6:
				Athlete[] containsAn = filterConstainAn(list);
				System.out.println("VDV co chua chu 'an':");
				display(containsAn);
				break;
			case 7:
				sortByNameLength(list);
				System.out.println("Da sap xep");
				break;
			case 8:
				display2Achieve(list);
				break;
			case 0:
				System.out.println("Da thoat chuong trinh");
				break;
			default:
				System.out.println("Lua chon khong hop le, Vui long nhap lai!");
			}
		} while (choice != 0);

	}
}
