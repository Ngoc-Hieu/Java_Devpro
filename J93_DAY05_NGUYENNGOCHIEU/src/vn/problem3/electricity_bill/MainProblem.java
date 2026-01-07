package vn.problem3.electricity_bill;


import java.util.Scanner;

public class MainProblem {
	static Scanner sc = new Scanner(System.in);
	
	public static HouseHold[] init() {
		String[] name = {
				"Tran Viet Hung","Quach Dong Tai","Duong Huyen Nhu",
				"Chu Phuong Dung", "Nguyen Chien Thang", "Duong Quoc Truong",
				"Tran Quang Khai","Phan Thu Phuong", "Dao Hung Manh",
				"Nguyen Ngoc Hieu","Ngo Viet Tiep", "Nguyen Minh Duc"
		};
		double[] kwh = {
				320, 201, 390, 679, 90, 821, 
				903, 400, 407, 209, 310, 600
		};
		HouseHold[] list = new HouseHold[name.length];
		for(int i=0 ; i<12; i++) {
			list[i] = new HouseHold();
			list[i].name = name[i];
			list[i].kwh = kwh[i];
		}
		return list;
	}
	private static void display(HouseHold[] list) {
		System.out.println("\n\t\tDANH SACH THU TIEN DIEN THANG 10");
		System.out.printf("%3s %-25s %-15s %-15s\n", "STT","Ho va ten chu ho",
				"So Kwh tieu thu", "     Thanh tien");
		
		int stt = 1;
		for(HouseHold h : list) {
			System.out.printf("%3d %-25s %,15.1f %,15.2f%n", stt++,h.name,
					h.kwh, HouseHold.total(h.kwh));
		}
		
	}
	public static void sortByKwhAscending(HouseHold[] list) {
	
		for(int i=0 ; i<list.length - 1 ; i++) {
			for(int j = i + 1 ; j< list.length ; j++) {
				if(list[j-1].kwh > list[j].kwh) {
					HouseHold h = list[i];
					list[i] = list[j];
					list[j] = h;
				}
			}
		}
	}
	private static void displayNameAsTruong(HouseHold[] list) {
		System.out.println("\n\t\tDANH SACH CHU HO TEN LA 'TRUONG'");
		System.out.printf("%3s %-25s %-15s %-15s\n", "STT","Ho va ten chu ho",
				"So Kwh tieu thu", "     Thanh tien");
		
		int stt = 1;
		for(HouseHold h : list) {
			if(getName(h.name).equalsIgnoreCase("truong")) {
			System.out.printf("%3d %-25s %,15.1f %,15.2f%n", stt++,h.name,
					h.kwh, HouseHold.total(h.kwh));
			}
		}
		if(stt == 1) System.out.println("Khong co ai ten la Truong");
	}
	private static void displayTop3(HouseHold[] list) {
		System.out.println("\n\t\tDANH SACH 3 GIA DINH THU TIEN DIEN NHIEU NHAT");
		System.out.printf("%3s %-25s %-15s %-15s\n", "STT","Ho va ten chu ho",
				"So Kwh tieu thu", "     Thanh tien");
		HouseHold[] lc = list.clone();
		sortByKwhAscending(lc);
		int stt = 1;
		
		for(int i=lc.length-1 ; i>=0 ; i--) {
			if(stt > 3) return;
			System.out.printf("%3d %-25s %,15.1f %,15.2f%n", stt++,lc[i].name,
					lc[i].kwh, HouseHold.total(lc[i].kwh));
		}
		
	}
	//Hàm lấy tên từ họ và tên
	public static String getName(String fullName) {
		int index = fullName.trim().lastIndexOf(" ");
		if(index == -1) { // CHỉ có 1 từ
			return fullName;
		}
		else {
			return fullName.trim().substring(index + 1);
		}
	}
	public static void sortByName(HouseHold[] list) {
		for(int i=0 ; i<list.length - 1 ; i++) {
			for(int j = i + 1 ; j< list.length ; j++) {
				if(getName(list[j-1].name).compareToIgnoreCase(getName(list[j].name)) > 0) {
					HouseHold h = list[i];
					list[i] = list[j];
					list[j] = h;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		HouseHold[] list = init();
		int choice;
		do {
			System.out.println("\t\tCHUONG TRINH QUAN LY TIEN DIEN");
			System.out.println("Chon mot bai toan can giai");
			System.out.println("\tGiai bai toan 1 -> Hien thi danh sach");
			System.out.println("\tGiai bai toan 2 -> Top 3 tien dien nhieu nhat");
			System.out.println("\tGiai bai toan 3 -> Chu ho ten Truong");
			System.out.println("\tGiai bai toan 4 -> Sap xep theo ten");
			System.out.println("\tGiai bai toan 5 -> Sap ttheo kwh");
			System.out.println("\tThoat -> bam phim so 0");
			
			System.out.print("Lua chon cua ban la gi?: ");
			 choice = Integer.parseInt(sc.nextLine());
			
			switch (choice) {
			case 1: 
				System.out.println("Giai bai toan so 1");
				display(list);
				break;
			case 2: 
				System.out.println("Giai bai toan so 2");
				displayTop3(list);
				break;
			case 3: 
				System.out.println("Giai bai toan so 3");
				displayNameAsTruong(list);
				break;
			case 4: 
				System.out.println("Giai bai toan so 4");
				sortByName(list);
				break;
			case 5: 
				System.out.println("Giai bai toan so 5");
				sortByKwhAscending(list);
				break;
			case 0: 
				System.out.println("Da thoat khoi ung dung");
				System.exit(0);
				
			default: System.out.println("Lua chon khong hop le, xin chon lai");
			}
			
		} while (true);
	}

	
}
