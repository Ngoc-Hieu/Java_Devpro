package homework_2;

import java.util.Scanner;

public class Main {
	public static void input(Citizen citizen) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap thong tin cong dan");
		System.out.printf("\tNhap so the can cuoc: ");
		citizen.soTheCanCuoc = sc.nextLine();
		System.out.printf("\tNhap ho dem: ");
		citizen.hoDem = sc.nextLine();
		System.out.printf("\tNhap ten: ");
		citizen.ten = sc.nextLine();
		System.out.println("\tNhap ngay thang nam sinh: ");
		System.out.printf("\t\tNhap ngay sinh: ");
		String day = sc.nextLine();
		System.out.printf("\t\tNhap thang sinh: ");
		String month = sc.nextLine();
		System.out.printf("\t\tNhap nam sinh: ");
		String year = sc.nextLine();
		citizen.ngaySinh = day+"/"+month+"/"+year;
		System.out.printf("\tNhap gioi tinh: ");
		citizen.gioiTinh = sc.nextLine();
		System.out.printf("\tNhap dia chi: ");
		citizen.diaChi = sc.nextLine();
		System.out.printf("\tNhap so dien thoai: ");
		citizen.soDienThoai = sc.nextLine();
	}
	public static String output(Citizen citizen) {
		return String.format("%-15s%-6s%-6s%-10s%-9s%-9s%-13s\n",
				citizen.soTheCanCuoc,citizen.hoDem,citizen.ten,
				citizen.ngaySinh,citizen.gioiTinh,citizen.diaChi,citizen.soDienThoai);
	}
	public static void main(String[] args) {
		Citizen ct1 = new Citizen() , 
				ct2 = new Citizen(), 
				ct3 = new Citizen();
		input(ct1);input(ct2);input(ct3);
		System.out.printf("%-15s%-6s%-6s%-10s%-9s%-9s%-13s\n",
		        "So CCCD", "Ho dem", "Ten", "Ngay sinh", "Gioi tinh", "Dia chi", "SDT");

		System.out.printf(output(ct1));
		System.out.printf(output(ct2));
		System.out.printf(output(ct3));
	}
}
