package homework_3;

import java.util.Scanner;

public class Main {
	public static void nhapMonHoc(MonHoc mh) {
		Scanner sc = new Scanner(System.in);	
		System.out.printf("\tNhap ma mon hoc: ");
		mh.maMonHoc = sc.nextLine();
		System.out.printf("\tNhap ten mon hoc: ");
		mh.tenMonHoc = sc.nextLine();
		System.out.printf("\tNhap he so mon hoc: ");
		mh.heSoMonHoc = sc.nextInt();
		System.out.printf("\tNhap diem so: ");
		mh.diemSoMonHoc = sc.nextFloat();
		sc.nextLine();
	}
	public static String hienThiMonHoc(MonHoc mh) {
		return String.format("%-20s%-20s%20d%20.1f%n\n",
				mh.maMonHoc,mh.tenMonHoc, mh.heSoMonHoc, mh.diemSoMonHoc);
	}
	public static void nhapSinhVien(SinhVien sv) {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Nhap sinh vien");
		System.out.printf("\tNhap ma sinh vien: ");
		sv.maSinhVien = sc.nextLine();
		System.out.printf("\tNhap ho dem: ");
		sv.hoDem = sc.nextLine();
		System.out.printf("\tNhap ten: ");
		sv.ten = sc.nextLine();
		System.out.println("\tNhap ngay thang nam sinh: ");
		System.out.printf("\t\tNhap ngay sinh: ");
		String day = sc.nextLine();
		System.out.printf("\t\tNhap thang sinh: ");
		String month = sc.nextLine();
		System.out.printf("\t\tNhap nam sinh: ");
		String year = sc.nextLine();
		sv.ngaySinh = day+"/"+month+"/"+year;
		System.out.println("\tNhap thong tin 5 mon hoc");
		System.out.println("\tNhap mon hoc 1");
		nhapMonHoc(sv.monHoc1);
		System.out.println("\tNhap mon hoc 2");
		nhapMonHoc(sv.monHoc2);
		System.out.println("\tNhap mon hoc 3");
		nhapMonHoc(sv.monHoc3);
		System.out.println("\tNhap mon hoc 4");
		nhapMonHoc(sv.monHoc4);
		System.out.println("\tNhap mon hoc 5");
		nhapMonHoc(sv.monHoc5);
	}
	public static float tinhDiemTB(SinhVien sv) {
		return (sv.monHoc1.diemSoMonHoc +
				sv.monHoc2.diemSoMonHoc + 
				sv.monHoc3.diemSoMonHoc +
				sv.monHoc4.diemSoMonHoc + 
				sv.monHoc5.diemSoMonHoc ) / 5;
	}
	public static String hienThiSinhVien(SinhVien sv) {
		return String.format("%-20s%-20s%-20s%-20s%20s",
				sv.maSinhVien,sv.hoDem,sv.ten,sv.ngaySinh,tinhDiemTB(sv));
	}
	public static void main(String[] args) {
		SinhVien sv = new SinhVien();
		nhapSinhVien(sv);
		System.out.printf("%-20s%-20s%-20s%-20s%20s\n",
				"Ma sinh vien","Ho dem","Ten","Ngay sinh" , "Diem trung binh");
		System.out.println(hienThiSinhVien(sv));
	}
}
